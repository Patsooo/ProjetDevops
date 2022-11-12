FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/waael-spring-boot.jar waeel-spring-boot.jar
ENTRYPOINT ["java","-jar","/waael-spring-boot.jar"]