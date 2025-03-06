<script setup>
import {useRoute} from 'vue-router'
const route = useRoute()
defineOptions({
  name: 'AppMain'
})
</script>

<template>
  <section class="app-main">
    <transition name="fade-transform" mode="out-in">
      <router-view :key="route.path"/>
    </transition>
  </section>
</template>

<style scoped>
.fixed-header + .app-main {
  padding-top: 60px;
}

.app-main {
  min-height: calc(100vh - 50px);
  width: 100%;
  position: relative;
  overflow: hidden;
  padding: 20px;
}
</style>

<style lang="scss">
// fix css style bug in open el-dialog
.el-popup-parent--hidden {
  .fixed-header {
    padding-right: 15px;
  }
}
</style>
