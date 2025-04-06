<script setup>
import {listBlog} from "@/api/blog.js";
import {ref} from "vue";
import {useRouter} from "vue-router";

defineOptions({
  name: 'BlogList'
})

let blogList = ref([])

let total = ref(0)

let queryParam = ref({
  pageNum: 1,
  pageSize: 5
})

const router = useRouter()

const handleQuery = () => {
  listBlog(queryParam.value).then(res => {
    blogList.value = res.data
    total.value = res.total
  })
}
handleQuery()

const toBlog = (item) => {
  router.push(`/blog/${item.id}`)
}
</script>

<template>
  <div>
    <div>
      <div class="ui padded attached segment m-padded-tb-large m-margin-bottom-big m-box" v-for="item in blogList" :key="item.id">
        <div class="ui middle aligned mobile reversed stackable">
          <div class="ui grid m-margin-lr">
            <!--标题-->
            <div class="row m-padded-tb-small">
              <h2 class="ui header m-center m-scaleup">
                <a href="javascript:;" @click.prevent="toBlog(item)" class="m-black">{{ item.title }}</a>
              </h2>
            </div>
            <!--文章简要信息-->
            <div class="row m-padded-tb-small">
              <div class="ui horizontal link list m-center">
                <div class="item m-datetime">
                  <i class="small calendar icon"></i><span>{{ item.createTime }}</span>
                </div>
                <div class="item m-common-black">
                  <i class="small pencil alternate icon"></i><span>字数≈{{ item.wordCount }}字</span>
                </div>
                <div class="item m-common-black">
                  <i class="small clock icon"></i><span>阅读时长≈{{ item.readTime }}分</span>
                </div>
              </div>
            </div>
            <!--分类-->
            <router-link :to="`/category/${item.category.id}`" class="ui orange large ribbon label">
              <i class="small folder open icon"></i><span class="m-text-500">{{ item.category.name }}</span>
            </router-link>
            <!--文章Markdown描述-->
            <div class="typo m-padded-tb-small line-numbers match-braces rainbow-braces" v-lazy="{selector: 'img'}" v-viewer v-html="item.description"></div>
            <!--阅读全文按钮-->
            <div class="row m-padded-tb-small m-margin-top">
              <a href="javascript:;" @click.prevent="toBlog(item)" class="color-btn">阅读全文</a>
            </div>
            <!--横线-->
            <div class="ui section divider m-margin-lr-no"></div>
            <!--标签-->
            <div class="row m-padded-tb-no">
              <div class="column m-padding-left-no">
                <router-link :to="`/tag/${tag.name}`" class="ui tag label m-text-500 m-margin-small" :class="tag.color" v-for="(tag,index) in item.tags" :key="index">{{ tag.name }}</router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <div class="ui bottom" style="display: flex; justify-content: center">
        <el-pagination
            v-model:current-page="queryParam.pageNum"
            v-model:page-size="queryParam.pageSize"
            background
            hide-on-single-page
            layout="prev, pager, next"
            :total="total"
            @current-change="handleQuery"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>
.img {
  width: 100%;
  height: 200px;
  background-size: cover;
  background-position: center;
}
</style>