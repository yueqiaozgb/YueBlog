<script setup>
import { isExternal } from '@/util/validate'

const props = defineProps({
  to: {
    type: String,
    required: true
  }
})

const type = () => {
  return isExternal(props.to) ? 'a' : 'router-link'
}

const linkProps = (to) => {
  if (isExternal(to)) {
    return {
      href: to,
      target: '_blank',
      rel: 'noopener'
    }
  }
  return {
    to: to
  }
}
</script>

<template>
  <component :is="type" v-bind="linkProps(to)">
    <slot />
  </component>
</template>

<style scoped>

</style>
