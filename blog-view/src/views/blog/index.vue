<script setup>
import { onBeforeRouteLeave, useRoute } from "vue-router";
import { getBlog } from "@/api/blog.js";
import { ref, watch, nextTick } from "vue";
import Prism from "prismjs";

defineOptions({
  name: 'Blog'
});

const route = useRoute();
const blog = ref({});

// 封装数据加载方法
const loadBlogData = async (id) => {
  try {
    const res = await getBlog(id);
    blog.value = res.data;

    // 等待DOM更新后执行高亮
    await nextTick();

    // 先销毁之前的tocbot实例
    tocbot.destroy();

    // 初始化代码高亮
    Prism.highlightAll();

    // 初始化目录生成器
    tocbot.init({
      tocSelector: '.js-toc',
      contentSelector: '.js-toc-content',
      headingSelector: 'h1,h2,h3,h4',
      positionFixedSelector: '.m-toc',
      scrollSmooth: true,
      scrollSmoothDuration: 420,
      scrollSmoothOffset: -55,
      headingsOffset: -18
    });
  } catch (error) {
    console.error('加载博客失败:', error);
  }
};

// 监听路由参数变化
watch(
    () => route.params.id,
    (newId) => {
      if (newId) {
        loadBlogData(newId);
      }
    },
    { immediate: true } // 立即执行一次初始化加载
);

onBeforeRouteLeave((to, from, next) => {
  tocbot.destroy();
  next();
});
</script>

<template>
  <div>
    <div class="ui padded attached segment m-padded-tb-large">
      <div class="ui middle aligned mobile reversed stackable">
        <div class="ui grid m-margin-lr">
          <!--标题-->
          <div class="row m-padded-tb-small">
            <h2 class="ui header m-center">{{ blog.title }}</h2>
          </div>
          <!--文章简要信息-->
          <div class="row m-padded-tb-small">
            <div class="ui horizontal link list m-center">
              <div class="item m-common-black">
                <i class="small pencil alternate icon"></i><span>字数≈{{ blog.wordCount }}字</span>
              </div>
              <div class="item m-common-black">
                <i class="small clock icon"></i><span>阅读时长≈{{ blog.readTime }}分</span>
              </div>
            </div>
          </div>
          <!--分类-->
          <router-link :to="`/category/${blog.category.id}`" class="ui orange large ribbon label" v-if="blog.category">
            <i class="small folder open icon"></i><span class="m-text-500">{{ blog.category.name }}</span>
          </router-link>
          <!--文章Markdown正文-->
          <div class="typo js-toc-content m-padded-tb-small match-braces rainbow-braces" v-lazy-container="{selector: 'img'}" v-viewer v-html="blog.content"></div>
          <!--横线-->
          <el-divider></el-divider>
          <!--标签-->
          <div class="row m-padded-tb-no">
            <div class="column m-padding-left-no">
              <router-link :to="`/tag/${tag.id}`" class="ui tag label m-text-500 m-margin-small" :style="{'background-color':tag.color+'!important', 'color':'white !important'}" v-for="(tag,index) in blog.tagList" :key="index">{{ tag.name }}</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="ui attached positive message">
      <ul class="list">
        <li>发表时间：{{ blog.createTime }}</li>
        <li>最后修改：{{ blog.updateTime }}</li>
        <li>本站点采用<a href="https://creativecommons.org/licenses/by/4.0/" target="_blank"> 署名 4.0 国际 (CC BY 4.0) </a>创作共享协议。可自由转载、引用，并且允许商业性使用。但需署名作者且注明文章出处。</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>

</style>