# 使用适当的基础镜像
FROM openjdk:17-jdk

# 设置工作目录
WORKDIR /app

# 复制打包后的Spring Boot应用程序到容器中
COPY yueblog.jar .

# 定义运行时环境变量
ENV JAVA_OPTS=""

# 运行应用程序
CMD ["java", "-jar", "yueblog.jar"]
