<script setup>
import {onMounted} from "vue";
import tocbot from "tocbot";

defineOptions({
  name: 'Tocbot'
})

onMounted(() => {
  if (window.document.querySelector('.js-toc-content')) {
    initTocbot()
  }
})

const initTocbot = () => {
  tocbot.init({
    // Where to render the table of contents.
    tocSelector: '.js-toc',
    // Where to grab the headings to build the table of contents.
    contentSelector: '.js-toc-content',
    // Which headings to grab inside of the contentSelector element.
    headingSelector: 'h1,h2,h3,h4',
    // Element to add the positionFixedClass to.
    positionFixedSelector: '.m-toc',
    // Smooth scrolling enabled.
    scrollSmooth: true,
    // Smooth scroll duration.
    scrollSmoothDuration: 420,
    //到顶部导航条的距离
    scrollSmoothOffset: -55,
    // Headings offset between the headings and the top of the document (this is meant for minor adjustments).
    // Can also be used to account for scroll height discrepancies from the use of css scroll-padding-top
    headingsOffset: -18
  })
}
</script>

<template>
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

</style>