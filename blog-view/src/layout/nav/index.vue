<script setup>
import {ref} from "vue";

defineOptions({
  name: 'Nav'
})

const {blogName, categoryList} = defineProps(['blogName', 'categoryList'])

const nav = ref(null)

</script>

<template>
  <div ref="nav" class="ui fixed inverted stackable pointing menu">
    <div class="ui container">
      <router-link to="/">
        <h3 class="ui header item m-blue">{{ blogName }}</h3>
      </router-link>
      <router-link to="/home" class="item">
        <i class="home icon"></i>首页
      </router-link>
    </div>
  </div>
</template>

<style scoped>
.m-blue {
  color: #48dbfb !important;
}
</style>