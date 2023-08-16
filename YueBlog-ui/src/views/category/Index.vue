<script setup lang="ts">
  import BlogList from "@/components/blog/BlogList.vue";
  import {computed, nextTick, ref, watch} from "vue";
  import {useRoute} from "vue-router";
  import {getBlogListByCategoryName} from "@/api/category.ts";

  import Prism from "prismjs"//导入代码高亮插件的core（里面提供了其他官方插件及代码高亮样式主题，你只需要引入即可）
  import "prismjs/themes/prism-tomorrow.min.css"
  import {ElNotification} from "element-plus";
  //引入代码高亮主题（这个去node_modules的安装prismjs中找到想使用的主题即可）


  defineOptions({
    name: 'BlogCategory',
  })

  const blogLists = ref([]);
  //创建一个totalpage的响应式数据
  const totalPage = ref(0);

  //根据route创建一个路由
  const route = useRoute();

  //创建一个计算属性，返回路由名称
  const categoryName = computed(() => {
    return route.params.name
  })

  //观测路由变化，当当前组件被重用时，要重新获取博客列表
  watch(() => route.fullPath, () => {
    if (route.name === 'category') {
      getBlogLists(1)
    }
  })

  const getBlogLists = (pageNum: number) => {
    getBlogListByCategoryName(categoryName.value, pageNum).then(res => {
      if (res.code === 200) {
        blogLists.value = res.rows
        totalPage.value = res.total
        nextTick(() => {
          // eslint-disable-next-line no-undef
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
  getBlogLists(1)
</script>

<template>
  <div>
    <div class="ui top segment" style="text-align: center">
      <h2 class="m-text-500">分类 {{ categoryName }} 下的文章</h2>
    </div>
    <BlogList :getBlogLists="getBlogLists" :blogList="blogLists" :totalPage="totalPage"/>
  </div>
</template>

<style scoped>

</style>