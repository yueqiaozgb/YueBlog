<script setup lang="ts">
import {onMounted, Ref, ref} from "vue";
import {useRoute, useRouter} from "vue-router";
import {getSearchBlogList} from "@/api/blog.ts";
import {useStore} from "@/store";
import {storeToRefs} from "pinia";
import { Edit } from '@element-plus/icons-vue'
import {ElNotification} from "element-plus";

defineOptions({
  name: 'BlogNav',
});

const props = defineProps(['blogName', 'categoryList']);

const useStores = useStore();

const {clientSize} = storeToRefs(useStores);

const mobileHide = ref(true);

const router = useRouter();

const route = useRoute();

const categoryRoute = (name: string) => {
  router.push(`/category/${name}`)
}

const queryString = ref('');

const timer: Ref<NodeJS.Timeout | null> = ref(null);

const debounceQuery = (queryString: string, callback: Function) => {
  if (timer.value) {
    clearTimeout(timer.value);
  }
  timer.value = setTimeout(() => querySearchAsync(queryString, callback), 1000);
};

const queryResult = ref([]);

const querySearchAsync = (queryString: string, callback: any) => {
  if (queryString == null
      || queryString.trim() === ''
      || queryString.indexOf('%') !== -1
      || queryString.indexOf('_') !== -1
      || queryString.indexOf('[') !== -1
      || queryString.indexOf('#') !== -1
      || queryString.indexOf('*') !== -1
      || queryString.trim().length > 20) {
    return
  }
  getSearchBlogList(queryString).then((res: any) => {
    if (res.code === 200) {
      queryResult.value = res.data
      if (queryResult.value.length === 0) {
        queryResult.value.push({title: '无相关搜索结果'})
      }
      callback(queryResult.value)
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

const toggle = () => {
  mobileHide.value = !mobileHide.value
}

const handleSelect = (item: any) => {
  if (item.blogId) {
    router.push(`/blog/${item.blogId}`)
  }
}

const nav = ref();

onMounted(() => {
  //监听页面滚动位置，改变导航栏的显示
  window.addEventListener('scroll', () => {
    //首页且不是移动端
    if (route.name === 'home' && clientSize.value.clientWidth > 768) {
      if (window.scrollY > clientSize.value.clientHeight / 2) {
        nav.value.classList.remove('transparent')
      } else {
        nav.value.classList.add('transparent')
      }
    }
  })
})

const dropdownPopperOptions = ref({
  modifiers: [
    {
      name: 'computeStyles',
      options: {
        adaptive: false
      }
    }
  ]
})

</script>

<template>
  <div ref="nav" class="ui fixed inverted stackable pointing menu" :class="{'transparent':route.name==='home' && clientSize.clientWidth>768}">
    <div class="ui container">
      <router-link to="/">
        <h3 class="ui header item m-blue">{{ props.blogName }}</h3>
      </router-link>
      <router-link to="/home" class="item" :class="{'m-mobile-hide': mobileHide,'active':route.name==='home'}">
        <i class="home icon"></i>首页
      </router-link>
      <el-dropdown trigger="click" @command="categoryRoute" :popper-options="dropdownPopperOptions">
				<span class="el-dropdown-link item" :class="{'m-mobile-hide': mobileHide,'active':route.name==='category'}">
					<i class="idea icon"></i>分类<i class="caret down icon"></i>
				</span>
        <template v-slot:dropdown>
          <el-dropdown-menu>
            <el-dropdown-item :command="category.categoryName" v-for="(category,index) in props.categoryList" :key="index">{{ category.categoryName }}</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
      <router-link to="/archive" class="item" :class="{'m-mobile-hide': mobileHide,'active':route.name==='archives'}">
        <i class="clone icon"></i>归档
      </router-link>
      <router-link to="/about" class="item" :class="{'m-mobile-hide': mobileHide,'active':route.name==='about'}">
        <i class="info icon"></i>关于我
      </router-link>
      <el-autocomplete
          v-model="queryString"
          :fetch-suggestions="debounceQuery"
          placeholder="Search..."
          class="right item m-search"
          :class="{'m-mobile-hide': mobileHide}"
          popper-class="m-search-item"
          @select="handleSelect">
        <template #suffix>
          <el-icon class="el-input__icon">
            <edit class="text" />
          </el-icon>
        </template>
        <template #default="{ item }">
          <div class="title">{{ item.blogTitle }}</div>
          <span class="content">{{ item.blogIntroduction }}</span>
        </template>
      </el-autocomplete>
      <button class="ui menu black icon button m-right-top m-mobile-show" @click="toggle">
        <i class="sidebar icon"></i>
      </button>
    </div>
  </div>
</template>

<style>
.ui.fixed.menu .container {
  width: 1400px !important;
  margin-left: auto !important;
  margin-right: auto !important;
}

.ui.fixed.menu {
  transition: .3s ease-out;
}

.ui.inverted.pointing.menu.transparent {
  background: transparent !important;
}

.ui.inverted.pointing.menu.transparent .active.item:after {
  background: transparent !important;
  transition: .3s ease-out;
}

.ui.inverted.pointing.menu.transparent .active.item:hover:after {
  background: transparent !important;
}

.el-dropdown-link {
  outline-style: none !important;
  outline-color: unset !important;
  height: 100%;
  cursor: pointer;
}

.el-dropdown-menu {
  margin: 7px 0 0 0 !important;
  padding: 0 !important;
  border: 0 !important;
}

.el-dropdown-menu__item {
  padding: 0 15px !important;
  color: rgba(16, 11, 11, 0.9) !important;
}

.el-popper .el-popper__arrow::after {
  content: none !important;
}

.el-popper__arrow {
  display: none !important;
}

.m-search {
  min-width: 220px;
  padding: 0 !important;
  color: rgba(255, 255, 255, .9);
}

.m-search input {
  color: rgba(16, 11, 11, 0.9);
  border: 0px !important;
  background-color: inherit;
  padding: .67857143em 2.1em .67857143em 1em;
}

.m-search i {
  color: rgb(255, 255, 255) !important;
}

.m-search-item {
  min-width: 350px !important;
}

.m-search-item li {
  line-height: normal !important;
  padding: 8px 10px !important;
}

.m-search-item li .title {
  text-overflow: ellipsis;
  overflow: hidden;
  color: rgba(0, 0, 0, 0.87);
}

.m-search-item li .content {
  text-overflow: ellipsis;
  font-size: 12px;
  color: rgba(0, 0, 0, .70);
}

.my-autocomplete li {
  line-height: normal;
  padding: 7px;
}
.my-autocomplete li .name {
  text-overflow: ellipsis;
  overflow: hidden;
}
.my-autocomplete li .addr {
  font-size: 12px;
  color: #b4b4b4;
}
.my-autocomplete li .highlighted .addr {
  color: #ddd;
}
.text{
  background: #00a7e0;
}
</style>