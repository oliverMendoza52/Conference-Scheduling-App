# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY ./target/conference-demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 5000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]