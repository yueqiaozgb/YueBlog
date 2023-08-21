<script setup lang="ts">
setTimeout(() => {
    window.L2Dwidget.init({
      pluginRootPath: '/live2dw',
      pluginJsPath: 'lib/',
      pluginModelPath: 'live2d-widget-model-koharu/assets/',
      tagMode: false,
      debug: false,
      model: { jsonPath: '/live2dw/live2d-widget-model-koharu/assets/koharu.model.json' },
      display: { position: 'right', width: 150, height: 300 },
      mobile: { show: true },
      log: false
    })
  }, 1000)
</script>

<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<style scoped>

</style>
