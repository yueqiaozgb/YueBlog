<script setup lang="ts">
import {ref} from "vue";
  import {getAbout} from "@/api/about.ts";
import { ElNotification } from 'element-plus'

  defineOptions({
    name: 'About',
  });

  const about = ref({
    aboutTitle: '',
    musicId: '',
    aboutContent: ''
  })

  const getData = () => {
    getAbout().then(res => {
      if (res.code === 200) {
        about.value = res.data
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
  getData()
</script>

<template>
  <div>
    <div class="ui top attached segment m-padded-lr-big">
      <h2 class="m-text-500" style="text-align: center">{{ about.aboutTitle }}</h2>
      <meting-js server="netease" type="song" :id="about.musicId" theme="#25CCF7" v-if="about.musicId!==''"></meting-js>
      <div class="typo content m-margin-top-large" v-viewer v-html="about.aboutContent"></div>
    </div>
  </div>
</template>

<style scoped>
.content ul li {
  letter-spacing: 1px !important;
}
</style>