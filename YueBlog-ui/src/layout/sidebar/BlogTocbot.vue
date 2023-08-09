<script setup lang="ts">
import {onMounted} from "vue";
import {useStore} from "@/store";

defineOptions({
  name: 'BlogTocbot'
})

onMounted(() => {
  if (window.document.querySelector('.js-toc-content')) {
    initTocbot()
  }
})

const useStores = useStore()

useStores.$subscribe((mutation) => {

})

const initTocbot = () => {

}
</script>

<template>
  <!--文章目录-->
  <div class="ui segments m-toc toc-wrapper m-box">
    <div class="ui secondary segment">
      <i class="list ul icon"></i>本文目录
    </div>
    <div class="ui yellow segment">
      <div class="js-toc"></div>
    </div>
  </div>
</template>

<style scoped>
.m-toc {
  z-index: 10 !important;
}

.m-toc .toc {
  overflow-y: auto
}

.m-toc .toc > ul {
  overflow: hidden;
  position: relative
}

.m-toc .toc > ul li {
  list-style: none
}

.m-toc .toc-list {
  list-style-type: none;
  margin: 0;
  padding-left: 10px
}

.m-toc .toc-list li a {
  display: block;
  padding: 4px 0;
  font-weight: 300;
}

.m-toc .toc-list li a:hover {
  color: #fbbd08;
}

.m-toc a.toc-link {
  color: currentColor;
  height: 100%
}

.m-toc .is-collapsible {
  max-height: 1000px;
  overflow: hidden;
  transition: all 300ms ease-in-out
}

.m-toc .is-collapsed {
  max-height: 0
}

.m-toc.is-position-fixed {
  position: sticky !important;
  top: 60px
}

.m-toc .is-active-link {
  font-weight: 700;
  color: #fbbd08 !important;
}

.m-toc .toc-link::before {
  background-color: #EEE;
  content: ' ';
  display: inline-block;
  height: 0;
  left: 0;
  margin-top: -1px;
  position: absolute;
  width: 2px
}

.m-toc .is-active-link::before {
  background-color: #54BC4B
}
</style>