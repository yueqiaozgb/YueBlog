import {createApp} from 'vue'
import './style.css'
import App from './App.vue'
// 引入路由
import router from "./router";
// 引入element-plus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// 引入fomantic-ui
import 'fomantic-ui/dist/semantic.min.css'
import 'fomantic-ui/dist/semantic.min.js'

const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.mount('#app')
