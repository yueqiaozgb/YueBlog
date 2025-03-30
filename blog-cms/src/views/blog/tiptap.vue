<template>
  <div class="editor">
    <!-- 菜单栏 -->
    <div v-if="editor" class="menu">
      <button @click="editor.chain().focus().toggleBold().run()" :class="{ 'is-active': editor.isActive('bold') }">B</button>
      <button @click="editor.chain().focus().toggleItalic().run()" :class="{ 'is-active': editor.isActive('italic') }">I</button>
      <!-- 更多按钮... -->
    </div>

    <!-- 编辑器内容区域 -->
    <editor-content :editor="editor" />
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'
import { Editor, EditorContent } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'
import Image from '@tiptap/extension-image'

const editor = ref(null)
const content = ref('<p>初始内容</p>')

onMounted(() => {
  editor.value = new Editor({
    content: content.value,
    extensions: [
      StarterKit,
      Image // 添加图片扩展
    ],
    onUpdate: ({ editor }) => {
      content.value = editor.getHTML()
    }
  })
})

onBeforeUnmount(() => {
  editor.value.destroy()
})
</script>

<style>
/* 基础样式 */
.ProseMirror {
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  min-height: 200px;
}
.ProseMirror:focus {
  outline: none;
  border-color: #646cff;
}

/* 菜单样式 */
.menu button {
  padding: 4px 8px;
  margin-right: 4px;
  background: #f0f0f0;
  border: 1px solid #ccc;
  border-radius: 3px;
  cursor: pointer;
}
.menu button.is-active {
  background: #ddd;
}
</style>