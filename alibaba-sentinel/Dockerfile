FROM openjdk:8-jdk-alpine
LABEL maintainer=YangLong<410357434@163.com>
ARG JAR_FILE=sentinel-dashboard-1.7.1.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ADD ${JAR_FILE} /sentinel.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Djava.security.egd=file:/dev./urandom -jar /sentinel.jar"]