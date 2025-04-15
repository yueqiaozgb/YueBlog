# 使用官方Java 17运行时镜像
FROM eclipse-temurin:17-jre

# 设置容器时区（中国大陆时区）
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# 将编译好的JAR包复制到容器
COPY blog.jar /app/app.jar

# 设置容器启动命令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]