<script setup>
import {getBlog, listBlog} from "@/api/blog";
import {ref} from "vue";

defineOptions({
  name: 'Blog'
})

let queryParam = ref({
  categoryId: undefined,
  title: undefined
})

let blogList = ref([])

const query = () => {
  listBlog(queryParam.value).then(res => {
    blogList.value = res.data
    console.log(blogList)
  })
}

const reset = () => {
  queryParam.value = {
    categoryId: undefined,
    title: undefined
  }
  query()
}

query()
</script>

<template>
  <div>
    <el-form :inline="true" :model="queryParam">
      <el-form-item prop="categoryId" label="分类名称">
        <el-select v-model="queryParam.categoryId" placeholder="请选择分类" style="width: 200px">
          <el-option label="分类一" :value="1"></el-option>
          <el-option label="分类二" :value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="title" label="标题">
        <el-input v-model="queryParam.title" placeholder="请输入标题" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="query">查询</el-button>
        <el-button @click="reset">重置</el-button>
      </el-form-item>
    </el-form>

    <div>
      <el-button type="primary" @click="getBlog">新增</el-button>
      <el-button type="success" @click="getBlog">修改</el-button>
      <el-button type="danger" @click="getBlog">删除</el-button>
    </div>

    <el-table :data="blogList">
      <el-table-column prop="id" label="ID"/>
      <el-table-column prop="title" label="标题"/>
      <el-table-column prop="categoryId" label="分类"/>
      <el-table-column prop="wordCount" label="字数"/>
      <el-table-column prop="readTime" label="阅读时间/分"/>
      <el-table-column prop="createTime" label="创建时间"/>
    </el-table>
  </div>
</template>

<style scoped lang="scss">

</style>
