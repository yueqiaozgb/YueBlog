<script setup lang="ts">
import {getCurrentInstance, nextTick, onActivated, ref} from "vue";
import {useStore} from "@/store";
import {useRoute} from "vue-router";

defineOptions({
  name: "BlogPagination"
})

const props = defineProps(['getBlogLists', 'totalPage']);

const pageNum = ref(1)

const useStores = useStore()

onActivated(() => {
  nextTick(() => {
    if (!useStores.isBlogToHome) {
      //从其它页面路由到首页时，让首页的分页组件页码重置到第一页
      pageNum.value = 1
    }
  })
})

const route = useRoute()

const app = getCurrentInstance();

const handleCurrentChange = (newPage) => {
  //如果是首页，则滚动至Header下方
  if (route.name === 'home') {
    window.scrollTo({top: useStores.clientSize.clientHeight, behavior: 'smooth'})
  } else {
    //其它页面（分类和标签页）滚动至顶部
    app.appContext.config.globalProperties.scrollToTop()
  }
  pageNum.value = newPage
  props.getBlogLists(newPage)
}
</script>

<template>
  <div class="ui bottom" style="text-align:center">
    <el-pagination
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-count="totalPage"
        layout="prev, pager, next"
        background hide-on-single-page>
    </el-pagination>
  </div>
</template>

<style scoped>
.el-pagination.is-background .btn-next, .el-pagination.is-background .btn-prev, .el-pagination.is-background .el-pager li {
  background-color: #ffffff !important;
}

.el-pagination.is-background .el-pager li:not(.disabled).active {
  background-color: #409EFF !important;
}
</style>