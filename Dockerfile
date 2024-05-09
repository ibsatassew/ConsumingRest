# Use the official OpenJDK 11 image as a base
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java class file into the container
COPY QuotersClient.java /app

# Specify the command to run your Java application
CMD ["java", "Main"]
