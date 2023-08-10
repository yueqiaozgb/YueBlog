<script setup lang="ts">
  import BlogList from "@/components/blog/BlogList.vue";
  import {computed, nextTick, ref, watch} from "vue";
  import {useRoute} from "vue-router";
  import Prism from "prismjs";
  import {getBlogListByTagName} from "@/api/tag.ts";

  defineOptions({
    name: 'BlogTag'
  })

  const blogLists = ref([]);

  //创建一个totalpage的响应式数据
  const totalPage = ref(0);

  //根据route创建一个路由
  const route = useRoute();

  //创建一个计算属性，返回路由名称
  const tagName = computed(() => {
    return route.params.name
  })

  //观测路由变化，当当前组件被重用时，要重新获取博客列表
  watch(() => route.fullPath, () => {
    if (route.name === 'tag') {
      getBlogLists()
    }
  })

  const getBlogLists = (pageNum) => {
    getBlogListByTagName(tagName.value, pageNum).then(res => {
      if (res.code === 200) {
        blogLists.value = res.data.list
        totalPage.value = res.data.totalPage
        nextTick(() => {
          // eslint-disable-next-line no-undef
          Prism.highlightAll()
        })
      } else {
        console.log("error")
      }
    }).catch(() => {
      console.log('失败')
    })
  }
  getBlogLists()
</script>

<template>
  <div>
    <div class="ui top segment" style="text-align: center">
      <h2 class="m-text-500">标签 {{ tagName }} 下的文章</h2>
    </div>
    <BlogList :getBlogLists="getBlogLists" :blogList="blogLists" :totalPage="totalPage"/>
  </div>
</template>

<style scoped>

</style>