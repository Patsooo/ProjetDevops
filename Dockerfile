FROM openjdk:8-jdk-alpine
EXPOSE 8089
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} molkaApp.jar
ENTRYPOINT ["java","-jar","/molkaApp.jar"]
