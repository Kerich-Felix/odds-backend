# Use the official Maven image to build the app
FROM maven:3.9.5-openjdk-21 AS build

COPY . . 

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar++

EXPOSE 1010

ENTRYPOINT ["java", "-jar", "app.jar"]


