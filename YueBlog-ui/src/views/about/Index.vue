<script setup lang="ts">
import {ref} from "vue";
  import {getAbout} from "@/api/about.ts";

  defineOptions({
    name: 'About',
  });

  const about = ref({
    title: '',
    musicId: '',
    content: ''
  })

  const getData = () => {
    getAbout().then(res => {
      if (res.code === 200) {
        about.value = res.data
      } else {
        console.log(res.msg)
      }
    }).catch(() => {
      console.log("请求失败")
    })
  }
  getData()
</script>

<template>
  <div>
    <div class="ui top attached segment m-padded-lr-big">
      <h2 class="m-text-500" style="text-align: center">{{ about.title }}</h2>
      <meting-js server="netease" type="song" :id="about.musicId" theme="#25CCF7" v-if="about.musicId!==''"></meting-js>
      <div class="typo content m-margin-top-large" v-viewer v-html="about.content"></div>
    </div>
  </div>
</template>

<style scoped>
.content ul li {
  letter-spacing: 1px !important;
}
</style>