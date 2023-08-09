import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/css/base.css'
import '@/assets/css/icon/iconfont.css'
import '@/assets/css/typo.css'
import 'semantic-ui-css/semantic.min.css'
import './util/dateTimeFormatUtils.js'
import 'viewerjs/dist/viewer.css'
import Viewer from 'v-viewer'

const app = createApp(App);
const pinia = createPinia();
app.use(pinia);
app.use(router);
app.use(ElementPlus);
app.use(Viewer);

app.directive('debounce', {
    inserted: function (el, binding) {
        let [fn, event = "click", time = 300] = binding.value
        let timer
        el.addEventListener(event, () => {
            timer && clearTimeout(timer)
            timer = setTimeout(() => fn(), time)
        })
    }
})

app.directive('throttle', {
    inserted: function (el, binding) {
        let [fn, event = "click", time = 300] = binding.value
        let now, preTime
        el.addEventListener(event, () => {
            now = new Date()
            if (!preTime || now - preTime > time) {
                preTime = now
                fn()
            }
        })
    }
})

const cubic = value => Math.pow(value, 3);
const easeInOutCubic = value => value < 0.5 ? cubic(value * 2) / 2 : 1 - cubic((1 - value) * 2) / 2;

//滚动至页面顶部，使用 Element-ui 回到顶部 组件中的算法
app.config.globalProperties.scrollToTop =  () => {
    const el = document.documentElement
    const beginTime = Date.now()
    const beginValue = el.scrollTop
    const rAF = window.requestAnimationFrame || (func => setTimeout(func, 16))
    const frameFunc = () => {
        const progress = (Date.now() - beginTime) / 500;
        if (progress < 1) {
            el.scrollTop = beginValue * (1 - easeInOutCubic(progress))
            rAF(frameFunc)
        } else {
            el.scrollTop = 0
        }
    }
    rAF(frameFunc)
}

app.config.productionTip = false

app.mount('#app');
