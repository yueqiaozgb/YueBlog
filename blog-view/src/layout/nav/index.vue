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

<style scoped>
.m-blue {
  color: #48dbfb !important;
}
</style>