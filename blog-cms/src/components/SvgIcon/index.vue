<script setup>
import { isExternal } from '@/util/validate.js'

import { computed } from 'vue'
const props = defineProps({
  iconClass: {
    type: String,
    required: true,
  },
  className: {
    type: String,
    default: () => '',
  },
})

const external = computed(() => isExternal(props.iconClass))

const iconName = computed(() => {
  console.log(`#icon-${props.iconClass}`);
  return `#icon-${props.iconClass}`
})
const svgClass = computed(() => {
  return props.className ? 'svg-icon ' + props.className : 'svg-icon';
})

const styleExternalIcon = computed(() => {
  return {
    mask: `url(${props.iconClass}) no-repeat 50% 50%`,
    '-webkit-mask': `url(${props.iconClass}) no-repeat 50% 50%`
  }
})
</script>

<template>
  <div v-if="external" :style="styleExternalIcon" class="svg-external-icon svg-icon" />
  <svg v-else :class="svgClass" aria-hidden="true" >
    <use :xlink:href="iconName" />
  </svg>
</template>

<style scoped lang="scss">
.svg-icon {
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}

.svg-external-icon {
  background-color: currentColor;
  mask-size: cover!important;
  display: inline-block;
}
</style>
