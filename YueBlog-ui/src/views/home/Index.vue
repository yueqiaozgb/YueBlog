<script lang="ts">
import {useStore} from "@/store";
import {getBlogList} from "@/api/home.ts";
import {nextTick, ref} from "vue";
import BlogList from "@/components/blog/BlogList.vue";
import Prism from "prismjs";
import {ElNotification} from "element-plus";

export default {
  name: 'BlogHome',
  components: {BlogList},
  beforeRouteEnter(to, from, next) {
    next(vm => {
      const useStores = useStore()
      if (from.name !== 'blog') {
        //其它页面跳转到首页时，重新请求数据
        //设置一个flag，让首页的分页组件指向正确的页码
        useStores.isBlogToHome = false
        vm.getBlogLists(1)
      } else {
        //如果文章页面是起始访问页，首页将是第一次进入，即缓存不存在，要请求数据
        if (!vm.getBlogListFinish) {
          vm.getBlogLists(1)
        }
        //从文章页面跳转到首页时，使用首页缓存
        useStores.isBlogToHome = false
      }
    })
  },
  setup() {
    const blogList = ref([])

    const totalPage = ref(0)

    const getBlogListFinish = ref(false)
    const getBlogLists = (pageNum: number) => {
      getBlogList(pageNum).then(res => {
        if (res.code === 200) {
          blogList.value = res.rows
          totalPage.value = res.total
          nextTick(() => {
            // eslint-disable-next-line no-undef
            Prism.highlightAll()
          })
          getBlogListFinish.value = true
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
    return {
      blogList, totalPage, getBlogListFinish, getBlogLists
    }
  }
}
</script>

<template>
  <div>
    <BlogList :getBlogLists="getBlogLists" :blogList="blogList" :totalPage="totalPage"/>
  </div>
</template>

<style scoped>

</style>