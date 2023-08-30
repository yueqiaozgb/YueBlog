<script setup lang="ts">
import {dateFormat} from "@/util/dateTimeFormatUtils.ts";
import {useRouter} from "vue-router";
defineOptions({
  name: 'BlogItem'
})
defineProps(['blogList']);

const router = useRouter();
const toBlog = (blog: any) => {
  return router.push(`/blog/${blog.blogId}`)
}
</script>

<template>
  <div>
    <div class="ui padded attached segment m-padded-tb-large m-margin-bottom-big m-box" v-for="item in blogList" :key="item.blogId">
      <div class="ui large red right corner label" v-if="item.recommendIndex > 0">
        <i class="arrow alternate circle up icon"></i>
      </div>
      <div class="ui middle aligned mobile reversed stackable">
        <div class="ui grid m-margin-lr">
          <!--标题-->
          <div class="row m-padded-tb-small">
            <h2 class="ui header m-center m-scaleup">
              <a href="javascript:;" @click.prevent="toBlog(item)" class="m-black">{{ item.blogTitle }}</a>
            </h2>
          </div>
          <!--文章简要信息-->
          <div class="row m-padded-tb-small">
            <div class="ui horizontal link list m-center">
              <div class="item m-datetime">
                <i class="small calendar icon"></i><span>{{ dateFormat(item.createTime,'YYYY-MM-DD') }}</span>
              </div>
              <div class="item m-common-black">
                <i class="small pencil alternate icon"></i><span>字数≈{{ item.blogWords }}字</span>
              </div>
              <div class="item m-common-black">
                <i class="small clock icon"></i><span>阅读时长≈{{ item.readTime }}分</span>
              </div>
            </div>
          </div>
          <!--分类-->
          <router-link :to="`/category/${item.category.categoryName}`" class="ui orange large ribbon label">
            <i class="small folder open icon"></i><span class="m-text-500">{{ item.category.categoryName }}</span>
          </router-link>
          <!--文章Markdown描述-->
          <div class="typo m-padded-tb-small line-numbers match-braces rainbow-braces" v-html="item.blogIntroduction"></div>
          <!--阅读全文按钮-->
          <div class="row m-padded-tb-small m-margin-top">
            <a href="javascript:;" @click.prevent="toBlog(item)" class="color-btn">阅读全文</a>
          </div>
          <!--横线-->
          <div class="ui section divider m-margin-lr-no"></div>
          <!--标签-->
          <div class="row m-padded-tb-no">
            <div class="column m-padding-left-no">
              <router-link :to="`/tag/${tag.tagName}`" class="ui tag label m-text-500 m-margin-small" :class="tag.tagColor" v-for="(tag,index) in item.tags" :key="index">{{ tag.tagName }}</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>