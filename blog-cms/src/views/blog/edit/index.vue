<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import {addBlog, getBlog, updateBlog} from "@/api/blog";
import {addTag, listTag} from "@/api/tag";
import {listCategory} from "@/api/category";
import {ElMessage} from "element-plus";
import {confirmAdd, confirmUpdate} from "@/utils/comfirm";

defineOptions({
  name: 'EditBlog'
})

const route = useRoute()

let params = route.query;

let form = ref({})

let content = ref('')

let tagList = ref([])

let categoryList = ref([])

let formRef = ref()

let router = useRouter()

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
    formRef.value.validate(() => {
      confirmUpdate(form.value, updateBlog)
    })
  } else {
    formRef.value.validate(() => {
      confirmAdd(form.value, addBlog).then(res => {
        console.log(res)
        if (res.data !== -1) {
          router.push({path: '/blog/edit', query: {id: res.data}})
        }
      })
    })
  }
}

const isAdding = ref(false)
const optionName = ref('')

const onConfirm = () => {
  if (optionName.value) {
    let option = {name: optionName.value, color: '#FF0000'}
    confirmAdd(option, addTag).then(() => {
      getParamsList()
      clear()
    })
  }
}

const onAddOption = () => {
  isAdding.value = true
}

const clear = () => {
  optionName.value = ''
  isAdding.value = false
}
</script>

<template>
  <div>
    <el-form ref="formRef" :model="form" label-position="top">
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
            <el-select v-model="form.tagIdList" placeholder="请选择标签" style="width: 100%" multiple filterable>
              <el-option
                  v-for="item in tagList"
                  :key="item.id"
                  :label="item.name"
                  :value="item.id"/>
              <template #footer>
                <el-button v-if="!isAdding" text bg size="small" @click="onAddOption">
                  添加标签
                </el-button>
                <template v-else>
                  <el-input
                      v-model="optionName"
                      class="option-input"
                      placeholder="input option name"
                      size="small"
                      style="margin-bottom: 10px"
                  />
                  <el-button type="primary" size="small" @click="onConfirm">
                    确认
                  </el-button>
                  <el-button size="small" @click="clear">关闭</el-button>
                </template>
              </template>
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
