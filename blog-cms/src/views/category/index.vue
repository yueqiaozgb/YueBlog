<script setup>
import {ref} from "vue";
import {addCategory, delCategory, getCategory, listCategory, updateCategory} from "@/api/category";
import {delBlog, getBlog} from "@/api/blog";
import {ElMessage, ElMessageBox} from "element-plus";

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

let showDialog = ref(false)

let title = ref('')

let form = ref({})

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

const resetForm = () => {
  form.value = {
    id: undefined,
    name: undefined
  }
}

const cancel = () => {
  resetForm()
  showDialog.value = false
}

const submit = () => {
  showDialog.value = false
  if (form.value.id) {
    updateCategory(form.value).then(res => {
      if (res.code === 200) {
        ElMessage({
          type: 'success',
          message: res.msg,
        })
        handleQuery()
      }
    })
  } else {
    addCategory(form.value).then(res => {
      if (res.code === 200) {
        ElMessage({
          type: 'success',
          message: res.msg,
        })
        handleQuery()
      }
    })
  }
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  singleChoice.value = selection.length !== 1
  multipleChoice.value = !selection.length
}

const handleAdd = () => {
  title.value = '新增分类'
  resetForm()
  showDialog.value = true
}

const handleUpdate = (id) => {
  title.value = '修改分类'
  const options = id ? id : (ids.value.length > 0 ? ids.value[0] : null)
  getCategory(options).then(res => {
    form.value = res.data
    showDialog.value = true
  })
}

const handleDelete = (id) => {
  const options = id ? [id] : [...ids.value]
  if (options.length === 0) {
    return
  }
  ElMessageBox.confirm(
      '是否删除id为' + options + '的数据?',
      '提示',
      {
        confirmButtonText: '确认',
        cancelButtonText: '关闭',
        type: 'warning',
      }
  ).then(() => {
    delCategory(options).then(res => {
      if (res.code === 200) {
        ElMessage({
          type: 'success',
          message: res.msg,
        })
        handleQuery()
      }
    })
  })
}

handleQuery()
</script>

<template>
  <div>
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
      <el-button type="success" @click="handleUpdate(undefined)" :disabled="singleChoice">修改</el-button>
      <el-button type="danger" @click="handleDelete(undefined)" :disabled="multipleChoice">删除</el-button>
    </div>

    <el-table :data="categoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" align="center" width="55"/>
      <el-table-column prop="id" align="center" label="ID"/>
      <el-table-column prop="name" align="center" label="名称"/>
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

    <el-dialog v-model="showDialog" :title="title" width="800px">
      <el-form :model="form">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" style="width: 400px"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="cancel">取消</el-button>
          <el-button type="primary" @click="submit">
            确认
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<style scoped lang="scss">
.pagination {
  overflow: hidden;
}

.el-pagination {
  float: right; /* 右浮动 */
}
</style>
