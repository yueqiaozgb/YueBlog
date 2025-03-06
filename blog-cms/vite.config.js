import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
import {createSvgIconsPlugin} from 'vite-plugin-svg-icons'

// https://vite.dev/config/
export default defineConfig({
    plugins: [vue(),
        // 注册所有的svg文件生成svg雪碧图
        createSvgIconsPlugin({
            iconDirs: [path.resolve(process.cwd(), "src/icons/svg")], // icon存放的目录
            symbolId: "icon-[name]", // symbol的id
            inject: "body-last", // 插入的位置
            customDomId: "__svg__icons__dom__" // svg的id
        })],
    resolve: {
        alias: { "@": path.resolve(__dirname, "src") }
    }
})
