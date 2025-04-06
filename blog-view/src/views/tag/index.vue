<script setup>
import { useRoute, useRouter } from "vue-router";
import { getTag } from "@/api/tag.js";
import { ref, watch, onBeforeUnmount } from "vue";
import BlogList from "@/layout/content/bloglist/index.vue";

const route = useRoute();
const router = useRouter();
const tag = ref({});
const loading = ref(false);
let abortController = null;

watch(
    () => route.params.id,
    async (newId) => {
      // 取消上一个未完成的请求
      if (abortController) {
        abortController.abort();
      }
      abortController = new AbortController();

      if (!newId) return router.push('/home');

      try {
        loading.value = true;
        const res = await getTag(newId, {
          signal: abortController.signal
        });
        tag.value = res.data;
      } catch (error) {
        if (error.name !== 'AbortError') {
          console.error('加载失败:', error);
          // 这里可以添加错误提示逻辑
        }
      } finally {
        loading.value = false;
        abortController = null;
      }
    },
    { immediate: true }
);

onBeforeUnmount(() => {
  // 组件卸载时取消未完成请求
  if (abortController) {
    abortController.abort();
  }
});
</script>

<template>
  <div>
    <div class="ui top segment" style="text-align: center">
      <h2 class="m-text-500">标签 {{ tag.name }} 下的文章</h2>
      <div v-if="loading" class="ui active loader"></div>
    </div>
    <BlogList/>
  </div>
</template>