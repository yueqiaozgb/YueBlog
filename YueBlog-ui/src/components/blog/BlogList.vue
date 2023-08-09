<script setup lang="ts">
import BlogItem from "@/components/blog/BlogItem.vue";
import Pagination from "@/components/blog/Pagination.vue";
import {onMounted, ref} from "vue";

defineProps(['blogList', 'totalPage', 'getBlogLists']);

const list = ref();

onMounted(() => {
  if (list.value) {
    const minHeight = 1000;
    const currentHeight = list.value.clientHeight;
    if (currentHeight < minHeight) {
      list.value.style.height = `${minHeight}px`;
    }
  }
})
</script>

<template>
  <div ref="list">
    <!--content-->
    <BlogItem :blogList="blogList" v-viewer/>
    <!--分页-->
    <Pagination :getBlogLists="getBlogLists" :totalPage="totalPage"/>
  </div>
</template>

<style scoped>

</style>