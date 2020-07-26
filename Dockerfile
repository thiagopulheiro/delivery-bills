FROM openjdk:8-jdk-alpine
RUN apk add --no-cache bash coreutils
VOLUME /tmp
ADD wait-for-it.sh wait-for-it.sh
EXPOSE 8080
ARG JAR_FILE=target/deliverybills-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} deliverybills-0.0.1-SNAPSHOT.jar
