<script setup>
import Hamburger from '@/components/hamburger/index.vue'
import Breadcrumb from '@/components/breadcrumb/index.vue'
import SvgIcon from '@/components/svgIcon/index.vue'
import {ref} from "vue";
import {useAppStore} from '@/stores/index.js'
import {storeToRefs} from "pinia";
import { useRouter } from "vue-router";
import { ElMessage } from 'element-plus'

let user = ref({
  avatar: '/images/avatar.jpg'
})

const app = useAppStore()
const {sidebar} = storeToRefs(app)
const router = useRouter();

const toggleSideBar = () => {
  sidebar.opened = !sidebar.opened
  sidebar.withoutAnimation = false
}

const getUserInfo = () => {
  user = JSON.parse(window.localStorage.getItem('user') || null)
  if (!user) {
    router.push('/login')
  }
}

const logout = () => {
  window.localStorage.removeItem('token')
  window.localStorage.removeItem('user')
  router.push('/login')
  ElMessage.success('退出成功')
}
getUserInfo()
</script>

<template>
  <div class="navbar">
    <hamburger :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar"/>

    <breadcrumb class="breadcrumb-container"/>

    <div class="right-menu">
      <el-dropdown class="avatar-container" trigger="click">
        <div class="avatar-wrapper">
          <img :src="user.avatar" class="user-avatar" alt="头像">
        </div>
        <el-dropdown-menu slot="dropdown" class="user-dropdown">
          <a target="_blank" href="https://github.com/yueqiaozgb">
            <el-dropdown-item>
              <SvgIcon icon-class="github" class-name="svg"/>
              <span>GitHub</span>
            </el-dropdown-item>
          </a>
          <el-dropdown-item @click.native="logout">
            <SvgIcon icon-class="logout" class-name="svg"/>
            <span>退出</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<style scoped>

</style>
