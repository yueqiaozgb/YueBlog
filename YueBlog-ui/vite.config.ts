import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

import DefineOptions from 'unplugin-vue-define-options/vite';
import * as path from "path";
import { prismjsPlugin } from 'vite-plugin-prismjs';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), DefineOptions(),
    prismjsPlugin({
      // languages: ["json", "js"],
      languages: 'all',
      plugins: ["line-numbers"], //配置显示行号插件
      theme: "solarizedlight", //主题名称
      css: true,
    }),
  ],
  resolve: {
    alias: {
      '@': path.join(__dirname, "./src"),
    }
  }
});

