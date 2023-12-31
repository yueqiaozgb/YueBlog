<script lang="ts">
import {getBlogById} from "@/api/blog";
import {nextTick, onMounted, ref} from "vue";
import {dateFormat} from "@/util/dateTimeFormatUtils.ts";
import {useStore} from "@/store";
import {useRoute} from "vue-router";
import tocbot from "tocbot";

import Prism from "prismjs"//导入代码高亮插件的core（里面提供了其他官方插件及代码高亮样式主题，你只需要引入即可）
import "prismjs/themes/prism-tomorrow.min.css"
import {ElNotification} from "element-plus";
//引入代码高亮主题（这个去node_modules的安装prismjs中找到想使用的主题即可）

export default {
  name: 'Blog',
  methods: {dateFormat},
  setup() {
    const blog = ref({})
    const bigFontSize = ref(false)
    const useStores = useStore()
    const route = useRoute()
    const blogId = () => {
      return parseInt(<string>route.params.id)
    }
    const changeFocusMode = () => {
      useStores.focusMode = !useStores.focusMode
    }
    onMounted(() => {
      nextTick(() => {
        setTimeout(() => {
          Prism.highlightAll()// 全局代码高亮
        }, 100)
      })
    })
    const getBlog = (id = blogId()) => {
      getBlogById(id).then(res => {
        if (res.code === 200) {
          blog.value = res.data
          document.title = blog.value.blogTitle + useStores.siteInfo.webTitleSuffix
          //v-html渲染完毕后，渲染代码块样式
          nextTick(() => {
            // eslint-disable-next-line no-undef
            // Prism.highlightAll()
            //将文章渲染完成状态置为 true
            const useStores = useStore()
            useStores.isBlogRenderComplete = true
            Prism.highlightAll()
          })
        } else {
          ElNotification({
            title: '获取失败',
            message: res.msg,
            type: 'warning',
          })
        }
      }).catch((e) => {
        ElNotification({
          title: '请求失败',
          message: e,
          type: 'error',
        })
      })
    }
    getBlog()
    return {
      blog, bigFontSize, useStores, blogId, changeFocusMode, getBlog
    }
  },
  beforeRouteEnter(to, from, next) {
    //路由到博客文章页面之前，应将文章的渲染完成状态置为 false
    next(() => {
      // 当 beforeRouteEnter 钩子执行前，组件实例尚未创建
      // vm 就是当前组件的实例，可以在 next 方法中把 vm 当做 this用
      const useStores = useStore()
      useStores.isBlogRenderComplete = false
    })
  },
  beforeRouteLeave(to, from, next) {
    const useStores = useStore()
    useStores.focusMode = false
    // 从文章页面路由到其它页面时，销毁当前组件的同时，要销毁tocbot实例
    // 否则tocbot一直在监听页面滚动事件，而文章页面的锚点已经不存在了，会报"Uncaught TypeError: Cannot read property 'className' of null"
    tocbot.destroy()
    next()
  },
  beforeRouteUpdate(to, from, next) {
    // 一般有两种情况会触发这个钩子
    // ①当前文章页面跳转到其它文章页面
    // ②点击目录跳转锚点时，路由hash值会改变，导致当前页面会重新加载，这种情况是不希望出现的
    // 在路由 beforeRouteUpdate 中判断路径是否改变
    // 如果跳转到其它页面，to.path!==from.path 就放行 next()
    // 如果是跳转锚点，path不会改变，hash会改变，to.path===from.path, to.hash!==from.path 不放行路由跳转，就能让锚点正常跳转
    if (to.path !== from.path) {
      const useStores = useStore()
      useStores.focusMode = false
      //在当前组件内路由到其它博客文章时，要重新获取文章
      this.getBlog(to.params.id)
      //只要路由路径有改变，且停留在当前Blog组件内，就把文章的渲染完成状态置为 false
      useStores.isBlogRenderComplete = false
      next()
    }
  },
}

</script>

<template>
  <div>
    <div class="ui padded attached segment m-padded-tb-large">
      <div class="ui large red right corner label" v-if="blog.recommendIndex > 0">
        <i class="arrow alternate circle up icon"></i>
      </div>
      <div class="ui middle aligned mobile reversed stackable">
        <div class="ui grid m-margin-lr">
          <!--标题-->
          <div class="row m-padded-tb-small">
            <h2 class="ui header m-center">{{ blog.blogTitle }}</h2>
          </div>
          <!--文章简要信息-->
          <div class="row m-padded-tb-small">
            <div class="ui horizontal link list m-center">
              <div class="item m-datetime">
                <i class="small calendar icon"></i><span>{{ dateFormat(blog.createTime,'YYYY-MM-DD') }}</span>
              </div>
              <div class="item m-common-black">
                <i class="small pencil alternate icon"></i><span>字数≈{{ blog.blogWords }}字</span>
              </div>
              <div class="item m-common-black">
                <i class="small clock icon"></i><span>阅读时长≈{{ blog.readTime }}分</span>
              </div>
              <a class="item m-common-black" @click.prevent="bigFontSize=!bigFontSize">
                <div data-inverted="" data-tooltip="点击切换字体大小" data-position="top center">
                  <i class="font icon"></i>
                </div>
              </a>
              <a class="item m-common-black" @click.prevent="changeFocusMode">
                <div data-inverted="" data-tooltip="专注模式" data-position="top center">
                  <i class="book icon"></i>
                </div>
              </a>
            </div>
          </div>
          <!--分类-->
          <router-link :to="`/category/${blog.category.categoryName}`" class="ui orange large ribbon label" v-if="blog.category">
            <i class="small folder open icon"></i><span class="m-text-500">{{ blog.category.categoryName }}</span>
          </router-link>
          <!--文章Markdown正文-->
          <div class="typo js-toc-content m-padded-tb-small match-braces rainbow-braces" v-viewer :class="{'m-big-fontsize':bigFontSize}" v-html="blog.blogContent"></div>
          <!--横线-->
          <el-divider></el-divider>
          <!--标签-->
          <div class="row m-padded-tb-no">
            <div class="column m-padding-left-no">
              <router-link :to="`/tag/${tag.tagName}`" class="ui tag label m-text-500 m-margin-small" :class="tag.tagColor" v-for="(tag,index) in blog.tags" :key="index">{{ tag.tagName }}</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--博客信息-->
    <div class="ui attached positive message">
      <ul class="list">
        <li>作者：{{ useStores.introduction.name }}
          <router-link to="/about">（联系作者）</router-link>
        </li>
        <li>发表时间：{{ dateFormat(blog.createTime,'YYYY-MM-DD HH:mm')}}</li>
        <li>最后修改：{{ dateFormat(blog.updateTime,'YYYY-MM-DD HH:mm') }}</li>
        <li>本站点采用<a href="https://creativecommons.org/licenses/by/4.0/" target="_blank"> 署名 4.0 国际 (CC BY 4.0) </a>创作共享协议。可自由转载、引用，并且允许商业性使用。但需署名作者且注明文章出处。</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
.el-divider {
  margin: 1rem 0 !important;
}

h1::before, h2::before, h3::before, h4::before, h5::before, h6::before {
  display: block;
  content: " ";
  height: 55px;
  margin-top: -55px;
  visibility: hidden;
}
</style>