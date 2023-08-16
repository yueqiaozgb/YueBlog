<script setup lang="ts">
import BlogItem from "@/components/blog/BlogItem.vue";
import Pagination from "@/components/blog/Pagination.vue";

defineProps(['blogList', 'totalPage', 'getBlogLists']);

</script>

<template>
  <div>
    <!--content-->
    <BlogItem :blogList="blogList" v-viewer/>
    <!--分页-->
    <Pagination :getBlogLists="getBlogLists" :totalPage="totalPage"/>
  </div>
</template>

<style scoped>

</style>