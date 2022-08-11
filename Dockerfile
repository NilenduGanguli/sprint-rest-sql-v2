FROM openjdk:11-jre

COPY target/rest-api-sql-v2-0.0.1-SNAPSHOT.jar spring-rest-api.jar

EXPOSE 8089

ENTRYPOINT ["java","-jar","/spring-rest-api.jar"]