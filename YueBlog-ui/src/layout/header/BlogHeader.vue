<script setup lang="ts">
import {onMounted, ref} from "vue";
import {useStore} from "@/store";
import {storeToRefs} from "pinia";

defineOptions({
  name: 'BlogHeader',
});

const useStores = useStore();

const {clientSize} = storeToRefs(useStores)

useStores.$subscribe(() => {
  setHeaderHeight()
}, {detached: false})

const scrollToMain = () => {
  window.scrollTo({top: clientSize.value.clientHeight, behavior: 'smooth'})
}

const header = ref();

const setHeaderHeight = () => {
  header.value.style.height = clientSize.value.clientHeight + 'px'
}

onMounted(() => {
  setHeaderHeight()
})

</script>

<template>
  <header ref="header">
    <div class="view">
        <video autoplay loop muted class="background-video">
          <source src="/video/zm.mp4" type="video/mp4">
          您的浏览器不支持视频播放。
        </video>
    </div>
    <div class="text-malfunction" data-word="Yue's Blog">
      <div class="line"></div>
    </div>
    <div class="wrapper">
      <i class="ali-iconfont icon-down" @click="scrollToMain"></i>
    </div>
  </header>
</template>

<style scoped>
header {
  /* --percentage: 0.5; */
  user-select: none;
}

.view {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  justify-content: center;
}

.background-video {
  object-fit: cover;
  width: 100%;
  height: 100%;
}

.text-malfunction {
  position: absolute;
  top: 40%;
  left: 51.5%;
  transform: translate(-50%, -50%) scale(2.5);
  width: 220px;
  font-size: 34px;
  font-family: sans-serif;
  color: transparent;
}

.line {
  position: absolute;
  width: 200px;
  left: -1px;
  height: 1px;
  background: black;
  z-index: 50;
  animation: lineMove 5s ease-out infinite;
}

.text-malfunction:before, .text-malfunction:after {
  content: attr(data-word);
  position: absolute;
  top: 0;
  height: 36px;
  overflow: hidden;
  filter: contrast(200%);
}

.text-malfunction:before {
  left: 0;
  color: red;
  text-shadow: 1px 0 0 red;
  z-index: 30;
  animation: malfunctionAni 0.95s infinite;
}

.text-malfunction:after {
  left: -1px;
  color: cyan;
  text-shadow: -1px 0 0 cyan;
  z-index: 40;
  mix-blend-mode: lighten;
  animation: malfunctionAni 1.1s infinite 0.2s;
}

@keyframes lineMove {
  9% {
    top: 38px;
  }
  14% {
    top: 8px;
  }
  18% {
    top: 42px;
  }
  22% {
    top: 1px;
  }
  32% {
    top: 32px;
  }
  34% {
    top: 12px;
  }
  40% {
    top: 26px;
  }
  43% {
    top: 7px;
  }
  99% {
    top: 30px;
  }
}

@keyframes malfunctionAni {
  10% {
    top: -0.4px;
    left: -1.1px;
  }
  20% {
    top: 0.4px;
    left: -0.2px;
  }
  30% {
    left: .5px;
  }
  40% {
    top: -0.3px;
    left: -0.7px;
  }
  50% {
    left: 0.2px;
  }
  60% {
    top: 1.8px;
    left: -1.2px;
  }
  70% {
    top: -1px;
    left: 0.1px;
  }
  80% {
    top: -0.4px;
    left: -0.9px;
  }
  90% {
    left: 1.2px;
  }
  100% {
    left: -1.2px;
  }
}

.wrapper {
  position: absolute;
  width: 100px;
  bottom: 150px;
  left: 0;
  right: 0;
  margin: auto;
  font-size: 26px;
  z-index: 100;
}

.wrapper i {
  font-size: 60px;
  opacity: 0.5;
  cursor: pointer;
  position: absolute;
  top: 55px;
  left: 20px;
  animation: opener .5s ease-in-out alternate infinite;
  transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
}

.wrapper i:hover {
  opacity: 1;
}

@keyframes opener {
  100% {
    top: 65px
  }
}

.wave1, .wave2 {
  position: absolute;
  bottom: 0;
  transition-duration: .4s, .4s;
  z-index: 80;
}

.wave1 {
  height: 75px;
  width: 100%;
}

.wave2 {
  height: 90px;
  width: calc(100% + 100px);
  left: -100px;
}
</style>