<script setup lang="ts">
import BlogNav from "./nav/BlogNav.vue";
import BlogHeader from "./header/BlogHeader.vue";
import {getCurrentInstance, onMounted, ref, watch} from "vue";
import {useRoute} from "vue-router";
import Introduction from "@/layout/sidebar/Introduction.vue";
import {getHitokoto, getSite} from "@/api";
import {useStore} from "@/store";

defineOptions({
  name: 'Layout',
});

const siteInfo = ref({});

const categoryList = ref([]);

const tagList = ref([]);

const randomBlogList = ref([]);

const badges = ref([]);

const newBlogList = ref([]);

const hitokoto = ref({});

const route = useRoute();

const app = getCurrentInstance();

watch(() => route.name, () => {
  app.appContext.config.globalProperties.scrollToTop()
})

const getHitokotos = () => {
  getHitokoto().then(res => {
    hitokoto.value = res
  })
}
getHitokotos()

const useStores = useStore();

const getSites = () => {
  getSite().then(res => {
    if (res.code === 200) {
      siteInfo.value = res.data.siteInfo
      useStores.siteInfo = res.data.siteInfo
      badges.value = res.data.badges
      newBlogList.value = res.data.newBlogList
      categoryList.value = res.data.categoryList
      tagList.value = res.data.tagList
      randomBlogList.value = res.data.randomBlogList
      useStores.introduction = res.data.introduction
      document.title = route.meta.title + siteInfo.value.webTitleSuffix
    }
  })
}
getSites()

onMounted(() => {
  useStores.clientHeight = document.body.clientHeight
  useStores.clientWidth = document.body.clientWidth
  window.onresize = () => {
    useStores.clientHeight = document.body.clientHeight
    useStores.clientWidth = document.body.clientWidth
  }
})
</script>

<template>
  <div class="site">
    <!--顶部导航-->
    <BlogNav :blogName="siteInfo.blogName" :categoryList="categoryList"/>
    <!--首页图片-->
    <div class="m-mobile-hide">
      <BlogHeader v-if="route.name==='home'"/>
    </div>
    <!--内容区域-->
    <div class="m-display-none">
      <div class="m-padded-tb-big">
        <div class="ui container">
          <div class="ui stackable grid">
            <!--左侧-->
            <div class="three wide column m-mobile-hide">
              <Introduction :class="{'m-display-none':useStores.focusMode}"/>
            </div>
            <!--中间-->
            <div class="ten wide column">
              <router-view v-slot="{Component}">
                <keep-alive include="Home">
                  <component :is="Component"/>
                </keep-alive>
              </router-view>
            </div>
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