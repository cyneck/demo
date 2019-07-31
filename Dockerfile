FROM openjdk:8-jdk-alpine

MAINTAINER eric@qq.com

RUN wget http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
RUN tar xzvf apache-maven-3.3.9-bin.tar.gz

RUN cp -R apache-maven-3.3.9 /usr/local/bin
RUN export PATH=apache-maven-3.3.9/bin:$PATH
RUN export PATH=/usr/local/bin/apache-maven-3.3.9/bin:$PATH
RUN ln -s /usr/local/bin/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn

VOLUME /tmp

WORKDIR /tmp/build

ADD pom.xml /tmp/build/
ADD src /tmp/build/src

#构建应用
RUN mvn clean install -Dmaven.test.skip=true

ADD target/*.war app.war

EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.war"]
