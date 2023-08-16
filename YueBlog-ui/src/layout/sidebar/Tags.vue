<script setup lang="ts">
defineOptions({
  name: 'Tags',
})
const props = defineProps(['tagList']);
</script>

<template>
  <!--标签云-->
  <div class="ui segments m-box">
    <div class="ui secondary segment"><i class="tags icon"></i>标签云</div>
    <div class="ui yellow segment m-padding-small">
      <router-link :to="`/tag/${tag.tagName}`" class="ui label m-text-500" :class="tag.tagColor" v-for="(tag,index) in tagList" :key="index">
        {{ tag.tagName }}
      </router-link>
    </div>
  </div>
</template>

<style scoped>
.secondary.segment {
  padding: 10px;
}

.m-padding-small {
  padding: 7px;
}

.label {
  margin: 3px !important;
}
</style>