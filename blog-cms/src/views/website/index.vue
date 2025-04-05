<script setup>
import {ref} from "vue";
import {addSetting, delSetting, getSetting, getSettingType, listSetting, updateSetting} from "@/api/setting";
import {confirmAdd, confirmDel, confirmUpdate} from "@/utils/comfirm";
import ColorTag from "@/components/ColorTag.vue";

defineOptions({
  name: 'Setting'
})

let queryParam = ref({
  name: undefined,
  type: undefined,
  pageNum: 1,
  pageSize: 10
})

let settingList = ref([])

let settingTypeList = ref([])

let total = ref(0)

let ids = ref([])

let singleChoice = ref(true)

let multipleChoice = ref(true)

let showDialog = ref(false)

let title = ref('')

let form = ref({})

const handleQuery = () => {
  listSetting(queryParam.value).then(res => {
    settingList.value = res.data
    total.value = res.total
  })
}
handleQuery()

const reset = () => {
  queryParam.value = {
    name: undefined,
    type: undefined,
    pageNum: 1,
    pageSize: 10
  }
  handleQuery()
}

const resetForm = () => {
  form.value = {
    id: undefined,
    name: undefined,
    type: undefined,
    value: undefined
  }
}

const cancel = () => {
  resetForm()
  showDialog.value = false
}

const submit = () => {
  showDialog.value = false
  if (form.value.id) {
    confirmUpdate(form.value, updateSetting).then(() => {
      handleQuery()
    })
  } else {
    confirmAdd(form.value, addSetting).then(() => {
      handleQuery()
    })
  }
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  singleChoice.value = selection.length !== 1
  multipleChoice.value = !selection.length
}

const handleAdd = () => {
  title.value = '新增设置'
  resetForm()
  showDialog.value = true
}

const handleUpdate = (id) => {
  title.value = '修改设置'
  const options = id ? id : (ids.value.length > 0 ? ids.value[0] : null)
  getSetting(options).then(res => {
    form.value = res.data
    showDialog.value = true
  })
}

const handleDelete = (id) => {
  const options = id ? [id] : [...ids.value]
  if (options.length === 0) {
    return
  }
  confirmDel(options, delSetting).then(() => {
    handleQuery()
  })
}

const getParamsList = () => {
  getSettingType().then(res => {
    settingTypeList.value = res.data
  })
}
getParamsList()
</script>

<template>
  <div>
    <el-form :inline="true" :model="queryParam">
      <el-form-item prop="name" label="设置名称">
        <el-input v-model="queryParam.name" placeholder="请输入设置名称" style="width: 200px"></el-input>
      </el-form-item>
      <el-form-item prop="type" label="设置类型">
        <el-select v-model="queryParam.type" placeholder="请选择设置类型" style="width: 200px">
          <el-option
              v-for="item in settingTypeList"
              :key="item.value"
              :label="item.label"
              :value="item.value"/>
        </el-select>
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

    <el-table :data="settingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" align="center" width="55"/>
      <el-table-column prop="id" align="center" label="ID"/>
      <el-table-column prop="name" align="center" label="名称"/>
      <el-table-column prop="type" align="center" label="类型"/>
      <el-table-column prop="value" align="center" label="值"/>
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

    <el-dialog v-model="showDialog" :title="title" width="500px">
      <el-form :model="form">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" style="width: 400px"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="color">
          <el-select v-model="form.type" placeholder="请选择类型" style="width: 400px">
            <el-option
                v-for="item in settingTypeList"
                :key="item.value"
                :label="item.label"
                :value="item.value"/>
          </el-select>
        </el-form-item>
        <el-form-item label="设置值" prop="value">
          <el-input v-model="form.value" placeholder="请输入值" style="width: 400px"></el-input>
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
  float: right;
}
</style>