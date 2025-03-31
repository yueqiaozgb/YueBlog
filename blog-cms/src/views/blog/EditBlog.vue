<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";

defineOptions({
  name: 'EditBlog'
})

const router = useRouter()
const route = useRoute()

let params = route.params;

let title = ref('')

let content = ref('')

if (params.id) {
  title.value = '编辑博客'
} else {
  title.value = '新增博客'
}

</script>

<template>
  <div>
    <mavon-editor ref="mavonEditorRef" v-model="content" :ishljs="true"/>
  </div>
</template>

<style scoped lang="scss">

</style>
