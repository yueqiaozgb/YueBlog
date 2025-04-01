<script setup>
import {ref} from "vue";
import {listCategory} from "@/api/category";
import {getBlog} from "@/api/blog";

defineOptions({
  name: 'Category'
})

let queryParam = ref({
  name: undefined,
  pageNum: 1,
  pageSize: 10
})

let categoryList = ref([])

let total = ref(0)

let ids = ref([])

let singleChoice = ref(true)

let multipleChoice = ref(true)

let show = ref(false)

const handleQuery = () => {
  listCategory(queryParam.value).then(res => {
    categoryList.value = res.data
    total.value = res.total
  })
}

const reset = () => {
  queryParam.value = {
    name: undefined,
    pageNum: 1,
    pageSize: 10
  }
  handleQuery()
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  singleChoice.value = selection.length !== 1
  multipleChoice.value = !selection.length
}

const handleAdd = () => {
  show.value = true
}

const handleDelete = (id) => {

}

handleQuery()
</script>

<template>
  <el-form :inline="true" :model="queryParam">
    <el-form-item prop="name" label="分类名称">
      <el-input v-model="queryParam.name" placeholder="请输入分类名称" style="width: 200px"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleQuery">查询</el-button>
      <el-button @click="reset">重置</el-button>
    </el-form-item>
  </el-form>

  <div>
    <el-button type="primary" @click="handleAdd">新增</el-button>
    <el-button type="success" @click="getBlog" :disabled="singleChoice">修改</el-button>
    <el-button type="danger" @click="handleDelete(undefined)" :disabled="multipleChoice">删除</el-button>
  </div>

  <el-table :data="categoryList" @selection-change="handleSelectionChange">
    <el-table-column type="selection" align="center" width="55"/>
    <el-table-column prop="id" align="center" label="ID"/>
    <el-table-column prop="name" align="center" label="名称"/>
    <el-table-column prop="createTime" align="center" label="创建时间"/>
    <el-table-column fixed="right" align="center" label="操作" min-width="120">
      <template #default="scope">
        <el-button type="success" size="small">修改</el-button>
        <el-button type="danger" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss">

</style>
