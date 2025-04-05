<script setup>
import {ref} from "vue";
import {listTag} from "@/api/tag.js";

defineOptions({
  name: 'Tags'
})

let tagList = ref([])

listTag().then(res => {
  tagList.value = res.data
})

</script>

<template>
  <div class="ui segments m-box">
    <div class="ui secondary segment"><i class="tags icon"></i>标签云</div>
    <div class="ui yellow segment m-padding-small">
      <router-link
          v-for="(tag,index) in tagList"
          :to="`/tag/${tag.id}`"
          class="ui label m-text-500"
          :style="{'background-color':tag.color+'!important', 'color':'white !important'}"
          :key="index">
        {{ tag.name }}
      </router-link>
    </div>
  </div>
</template>

<style scoped>

</style>