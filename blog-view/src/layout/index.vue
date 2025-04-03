<script setup>
import Nav from "@/layout/nav/index.vue";
import {ref} from "vue";
import {listCategory} from "@/api/category.js";

let blogName = ref('Yue Blog')
let categoryList = ref([])

const getParamsList = () => {
  listCategory().then(res => {
    categoryList.value = res.data
  })
}
getParamsList()
</script>

<template>
  <div class="layout">
    <!--顶部导航-->
    <Nav :blogName="blogName" :categoryList="categoryList"/>
  </div>
</template>

<style scoped>
.layout {
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>
