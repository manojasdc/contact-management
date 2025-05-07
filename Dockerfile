# Build stage
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar sms-app.jar

# Add timestamp and user information
LABEL build.timestamp="2025-05-05 06:49:09"
LABEL build.user="manojasdc"

EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "sms-app.jar"]
