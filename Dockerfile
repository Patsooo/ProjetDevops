FROM openjdk:8
ADD target/tpAchatProject-1.0.jar haythemoperateur.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "haythemoperateur.jar"]