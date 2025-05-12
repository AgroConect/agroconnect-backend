# Start from an OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/agroconnect-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (or whatever port your app uses)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
