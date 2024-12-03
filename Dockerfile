FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY build/libs/grocerybooking-0.0.1-SNAPSHOT.jar /app/grocerybooking.jar

ENTRYPOINT ["java", "-jar", "/app/grocerybooking.jar"]

EXPOSE 7777