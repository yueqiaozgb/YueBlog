<script setup>
import {getBlog} from "@/api/blog";

defineOptions({
  name: 'Blog'
})

getBlog(1).then(res => {
  console.log(res)
})
</script>

<template>

</template>

<style scoped lang="scss">

</style>
