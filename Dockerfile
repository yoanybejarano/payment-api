FROM openjdk:17-oracle

ADD target/*.jar app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","app.jar"]