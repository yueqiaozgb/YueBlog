<script setup>
import {useRoute} from "vue-router";
import {ref} from "vue";
import {addBlog, getBlog, updateBlog} from "@/api/blog";
import {listTag} from "@/api/tag";
import {listCategory} from "@/api/category";
import {ElMessage} from "element-plus";

defineOptions({
  name: 'EditBlog'
})

const route = useRoute()

let params = route.query;

let form = ref({})

let content = ref('')

let tagList = ref([])

let categoryList = ref([])

if (params.id) {
  getBlog(params.id).then(res => {
    form.value = res.data
    console.log(res)
  })
}

const getParamsList = () => {
  listTag().then(res => {
    tagList.value = res.data
  })
  listCategory().then(res => {
    categoryList.value = res.data
  })
}
getParamsList()

const submit = () => {
  if (form.value.id) {
    updateBlog(form.value).then(res => {
      if (res.code === 200) {
        ElMessage({
          type: 'success',
          message: res.msg,
        })
      } else {
        ElMessage({
          type: 'error',
          message: res.msg,
        })
      }
    })
  } else {
    addBlog(form.value).then(res => {
      if (res.code === 200) {
        ElMessage({
          type: 'success',
          message: res.msg,
        })
      } else {
        ElMessage({
          type: 'error',
          message: res.msg,
        })
      }
    })
  }
}
</script>

<template>
  <div>
    <el-form :model="form" label-position="top">
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="标题" prop="title">
            <el-input v-model="form.title" placeholder="请输入标题"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="封面" prop="cover">
            <el-input v-model="form.cover" placeholder="请输入封面"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="简介" prop="description">
        <mavon-editor v-model="form.description" style="width: 100%"/>
      </el-form-item>
      <el-form-item label="正文" prop="content">
        <mavon-editor v-model="form.content" style="width: 100%"/>
      </el-form-item>
      <el-row :gutter="24">
        <el-col :span="12">
          <el-form-item label="分类" prop="categoryId">
            <el-select v-model="form.categoryId" placeholder="请选择分类" style="width: 100%">
              <el-option
                  v-for="item in categoryList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"/>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="标签" prop="tagIdList">
            <el-select v-model="form.tagIdList" placeholder="请选择标签" style="width: 100%" multiple>
              <el-option
                  v-for="item in tagList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"/>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-button type="primary" @click="submit">保存</el-button>
    </el-form>
  </div>
</template>

<style scoped lang="scss">

</style>
