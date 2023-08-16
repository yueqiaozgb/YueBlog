<script setup lang="ts">
import BlogNav from "./nav/BlogNav.vue";
import BlogHeader from "./header/BlogHeader.vue";
import Footer from "@/layout/footer/Footer.vue";
import {onMounted, ref} from "vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import Introduction from "@/layout/sidebar/Introduction.vue";
import {getHitokoto, getSite} from "@/api";
import {useStore} from "@/store";
import RandomBlog from "@/layout/sidebar/RandomBlog.vue";
import Tags from "@/layout/sidebar/Tags.vue";
import BlogTocbot from "@/layout/sidebar/BlogTocbot.vue";
import MyAPlayer from "@/layout/footer/MyAPlayer.vue";

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
  useStores.clientSize.clientHeight = document.body.clientHeight
  useStores.clientSize.clientWidth = document.body.clientWidth
  window.onresize = () => {
    useStores.clientSize.clientHeight = document.body.clientHeight
    useStores.clientSize.clientWidth = document.body.clientWidth
  }
})

onBeforeRouteUpdate((to, from, next) => {
  if (to.path !== from.path) {
    scrollToTop();
  }
  next();
});

const scrollToTop = () => {
  const duration = 300; // 动画持续时间（毫秒）
  const start = window.scrollY;
  const startTime = performance.now();

  const animateScroll = (timestamp) => {
    const elapsed = timestamp - startTime;
    const progress = Math.min(elapsed / duration, 1);
    const easeInOutQuad = (t) => t<.5 ? 2*t*t : -1+(4-2*t)*t;

    window.scrollTo(0, start - (start * easeInOutQuad(progress)));

    if (elapsed < duration) {
      requestAnimationFrame(animateScroll);
    }
  };

  requestAnimationFrame(animateScroll);
};
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
    <div class="main">
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
            <!--右侧-->
            <div class="three wide column m-mobile-hide">
              <RandomBlog :randomBlogList="randomBlogList" :class="{'m-display-none':useStores.focusMode}"/>
              <Tags :tagList="tagList" :class="{'m-display-none':useStores.focusMode}"/>
              <!--只在文章页面显示目录-->
              <BlogTocbot v-if="route.name==='blog'"/>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!--APlayer-->
    <div class="m-mobile-hide">
      <MyAPlayer/>
    </div>

    <!--回到顶部-->
    <el-backtop ref="backtop" style="box-shadow: none;background: none;z-index: 9999;">
      <img src="/img/paper-plane.png" style="width: 40px;height: 40px;">
    </el-backtop>

    <!--底部footer-->
    <Footer :siteInfo="siteInfo" :badges="badges" :newBlogList="newBlogList" :hitokoto="hitokoto"/>
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