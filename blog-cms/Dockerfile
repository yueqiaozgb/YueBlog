FROM nginx:alpine

# 删除默认配置
RUN rm -rf /etc/nginx/conf.d/*

# 复制自定义配置文件，并确保以.conf结尾
COPY nginx.conf /etc/nginx/conf.d/app.conf

# 复制静态文件到容器
COPY dist /usr/share/nginx/html

# 暴露Nginx配置中指定的端口
EXPOSE 8090

# 启动Nginx
CMD ["nginx", "-g", "daemon off;"]
