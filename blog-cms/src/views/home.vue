<template>
  <div>
    <p>这是首页，请尝试使用 Ctrl + Space（空格键） 唤醒菜单搜索，搜索并进入你想要的页面🧐。</p>
    <p class="flex items-center">（注意：如果你的电脑是 mac/mbp，请使用 command + k 来唤醒菜单搜索。）</p>
  </div>
</template>

<script setup>
import {blog} from "@/api/blog";

blog().then(res => {
  console.log(res)
})
</script>

<style lang="scss" scoped></style>
