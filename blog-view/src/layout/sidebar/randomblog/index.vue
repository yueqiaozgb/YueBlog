<script setup>
import {randomBlog} from "@/api/blog.js";
import {ref} from "vue";
import {useRouter} from "vue-router";

defineOptions({
  name: 'RandomBlog'
})

let randomBlogList = ref([])

const router = useRouter()

randomBlog().then(res => {
  randomBlogList.value = res.data
})

const toBlog = (blog) => {
  router.push('/blog/' + blog.id)
}
</script>

<template>
  <div class="ui segments m-box">
    <div class="ui secondary segment"><i class="bookmark icon"></i>随机文章</div>
    <div class="ui yellow segment">
      <div class="ui divided items">
        <div class="m-item" v-for="blog in randomBlogList" :key="blog.id" @click.prevent="toBlog(blog)">
          <div class="img" :style="{'background-image':'url(' + blog.cover + ')'}"></div>
          <div class="info">
            <div class="date">{{ blog.createTime }}</div>
            <div class="title">{{ blog.title }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.secondary.segment {
  padding: 10px;
}

.ui.divided.items .m-item:first-child {
  margin-top: 0;
}

.ui.divided.items .m-item {
  margin-top: 1rem;
  height: 7rem;
  position: relative;
  overflow: hidden;
  border-radius: 5px;
  cursor: pointer;
  user-select: none;
}

.ui.divided.items .m-item .img {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  object-fit: cover;
  background-position-x: center;
  background-position-y: center;
  background-size: cover;
}

.ui.divided.items .m-item .info {
  z-index: 1;
  background: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.8));
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
  padding: .5rem !important;
  font-size: 12px;
  color: white;
}

.ui.divided.items .m-item .info .title {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
  word-break: break-word;
}
</style>