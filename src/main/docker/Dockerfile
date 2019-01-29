# 指定 base 镜像
FROM openjdk:8-jdk-alpine
# 设置镜像的作者
MAINTAINER Eric
# COPY：将文件从 build context 复制到镜像。例如：COPY <src> <dest> 或者COPY ["<src>","<dest>"]
# VOLUME：将文件或目录声明为 volume。
VOLUME /tmp
# WORKDIR：指定后面的 RUN, CMD, ENTRYPOINT, ADD 或 COPY 指令在镜像中为当前工作目录。进入容器，当前目录即为 WORKDIR。如果 WORKDIR 不存在，Docker 会自动为我们创建。
# RUN：在容器中运行指定的命令
# CMD：容器启动时运行指定的命令
# ADD：与 COPY 类似，从 build context 复制文件到镜像。不同的是，如果 src 是归档文件（tar, zip, tgz, xz 等），文件会被自动解压到 dest。jar包和Dockerfile必须在同级目录下
COPY *.jar app.jar
# ENV：设置环境变量，环境变量可被后面的指令使用,例如：ENV MY_VERSION 1.3 \ RUN apt-get install -y mypackage=$MY_VERSION
# EXPOSE：指定容器中的进程会监听某个端口，Docker 可以将该端口暴露出来。
# 此处tomcat运行默认是8080端口，为了方便，在新建容器时，需要手动绑定主机8000端口到容器的8080端口
EXPOSE 8000
# ENTRYPOINT：设置容器启动时运行的命令。
ENTRYPOINT ["java","-jar","/app.jar"]
