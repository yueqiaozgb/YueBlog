<script setup>
import Nav from "@/layout/nav/index.vue";
import {ref} from "vue";
import {listCategory} from "@/api/category.js";
import Introduction from "@/layout/introduction/index.vue";

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
  <div>
    <!--顶部导航-->
    <Nav :blogName="blogName" :categoryList="categoryList"/>

    <div class="main">
      <div class="m-padded-tb-big">
        <div class="ui container">
          <div class="ui stackable grid">
            <!--左侧-->
            <div class="three wide column m-mobile-hide">
              <Introduction/>
            </div>
            <!--中间-->
            <div class="ten wide column">
              <keep-alive include="Home">
                <router-view/>
              </keep-alive>
            </div>
            <!--右侧-->

          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<style scoped>
.site {
  display: flex;
  min-height: 100vh; /* 没有元素时，也把页面撑开至100% */
  flex-direction: column;
}

.main {
  margin-top: 40px;
  flex: 1;
}

.main .ui.container {
  width: 1400px !important;
  margin-left: auto !important;
  margin-right: auto !important;
}

.ui.grid .three.column {
  padding: 0;
}

.ui.grid .ten.column {
  padding-top: 0;
}

.m-display-none {
  display: none !important;
}
</style>