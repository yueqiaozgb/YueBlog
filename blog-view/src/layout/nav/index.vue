<script setup>
import {ref} from "vue";
import {useRouter} from "vue-router";

defineOptions({
  name: 'Nav'
})

const {blogName, categoryList} = defineProps(['blogName', 'categoryList'])

const nav = ref(null)

const router = useRouter()

const categoryRoute = (name) => {
  router.push(`/category/${name}`)
}
</script>

<template>
  <div ref="nav" class="ui fixed inverted stackable pointing menu">
    <div class="ui container">
      <router-link to="/">
        <h3 class="ui header item m-blue">{{ blogName }}</h3>
      </router-link>
      <router-link to="/home" class="item">
        <i class="home icon"/>首页
      </router-link>
      <el-dropdown trigger="click" @command="categoryRoute">
        <span class="el-dropdown-link item">
					<i class="idea icon"></i>分类<i class="caret down icon"></i>
				</span>
        <template #dropdown>
          <el-dropdown-item
              v-for="item in categoryList"
              :command="item.id"
              :key="item.id"
          >
            {{ item.name }}
          </el-dropdown-item>
        </template>
      </el-dropdown>
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
</style>