import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index';
import pinia from './stores'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import initSvgIcon from './icons/index.js'
import 'virtual:svg-icons-register'

const app = createApp(App);
app
    .use(initSvgIcon)
    .use(ElementPlus)
    .use(pinia)
    .use(router)
    .mount('#app')
