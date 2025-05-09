<script setup>
import {delBlog, getBlog, listBlog} from "@/api/blog";
import {ref} from "vue";
import {ElMessage, ElMessageBox} from "element-plus";
import {useRouter} from "vue-router";
import {confirmDel} from "@/utils/comfirm";
import {listCategory} from "@/api/category";

defineOptions({
  name: 'Blog'
})

let queryParam = ref({
  pageNum: 1,
  pageSize: 10,
  categoryId: undefined,
  title: undefined
})

let blogList = ref([])

let categoryList = ref([])

let total = ref(0)

let ids = ref([])

let singleChoice = ref(true)

let multipleChoice = ref(true)

const router = useRouter()

const getParamsList = () => {
  listCategory().then(res => {
    categoryList.value = res.data
  })
}
getParamsList()

const handleQuery = () => {
  listBlog(queryParam.value).then(res => {
    blogList.value = res.data
    total.value = res.total
  })
}
handleQuery()

const handleDelete = (id) => {
  const options = id ? [id] : [...ids.value]
  if (options.length === 0) {
    return
  }
  confirmDel(options, delBlog).then(() => {
    handleQuery()
  })
}

const handleAdd = () => {
  router.push('/blog/edit')
}

const handleUpdate = (id) => {
  const options = id ? id : (ids.value.length > 0 ? ids.value[0] : null)
  router.push({path: '/blog/edit', query: {id: options}})
}

const reset = () => {
  queryParam.value = {
    categoryId: undefined,
    title: undefined,
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

const getCategoryName = (id) => {
  const category = categoryList.value.find(item => item.id === id)
  return category ? category.name : ''
}
</script>

<template>
  <div>
    <el-form :inline="true" :model="queryParam">
      <el-form-item prop="categoryId" label="分类名称">
        <el-select v-model="queryParam.categoryId" placeholder="请选择分类" style="width: 200px">
          <el-option
            v-for="item in categoryList"
            :key="item.id"
            :label="item.name"
            :value="item.id"/>
        </el-select>
      </el-form-item>
      <el-form-item prop="title" label="标题">
        <el-input v-model="queryParam.title" placeholder="请输入标题" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleQuery">查询</el-button>
        <el-button @click="reset">重置</el-button>
      </el-form-item>
    </el-form>

    <div>
      <el-button type="primary" @click="handleAdd">新增</el-button>
      <el-button type="success" @click="handleUpdate(undefined)" :disabled="singleChoice">修改</el-button>
      <el-button type="danger" @click="handleDelete(undefined)" :disabled="multipleChoice">删除</el-button>
    </div>

    <el-table :data="blogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" align="center" width="55"/>
      <el-table-column prop="id" align="center" label="ID"/>
      <el-table-column prop="title" align="center" label="标题"/>
      <el-table-column prop="categoryId" align="center" label="分类">
        <template #default="scope">
          <el-tag>{{ getCategoryName(scope.row.categoryId) }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="wordCount" align="center" label="字数"/>
      <el-table-column prop="readTime" align="center" label="阅读时间/分"/>
      <el-table-column prop="createTime" align="center" label="创建时间"/>
      <el-table-column fixed="right" align="center" label="操作" min-width="120">
        <template #default="scope">
          <el-button type="success" size="small" @click="handleUpdate(scope.row.id)">修改</el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="pagination">
      <el-pagination
          v-model:current-page="queryParam.pageNum"
          v-model:page-size="queryParam.pageSize"
          :page-sizes="[10, 20, 30, 50]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleQuery"
          @current-change="handleQuery"
      />
    </div>

  </div>
</template>

<style scoped lang="scss">
.pagination {
  overflow: hidden;
}

.el-pagination {
  float: right;
}
</style>
