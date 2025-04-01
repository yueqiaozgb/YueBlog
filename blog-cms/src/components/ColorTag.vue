<template>
  <el-tag
      class="color-tag"
      :style="{
      'background-color': color,
      'width': width,
      'height': height,
      'border-radius': round ? '50%' : borderRadius,
      'border': border ? `1px solid ${borderColor}` : 'none',
      'min-width': minWidth
    }"
      :title="color"
  />
</template>

<script setup>
defineProps({
  color: {
    type: String,
    default: '#951616',
    validator: (value) => /^#([0-9A-F]{3}){1,2}$/i.test(value)
  },
  width: {
    type: String,
    default: '100px'
  },
  height: {
    type: String,
    default: '20px'
  },
  borderRadius: {
    type: String,
    default: '4px'
  },
  round: {
    type: Boolean,
    default: false
  },
  border: {
    type: Boolean,
    default: false
  },
  borderColor: {
    type: String,
    default: '#dcdfe6'
  },
  minWidth: {
    type: String,
    default: '20px'
  }
})
</script>

<style scoped>
.color-tag {
  padding: 0;
  display: inline-block;
  vertical-align: middle;
  cursor: default;
  transition: all 0.2s ease;
}

.color-tag:hover {
  transform: scale(1.05);
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}
</style>