# Maven build container 
FROM maven:3.8.3-openjdk-17 AS BUILD_CONTAINER
WORKDIR /app
COPY . .
RUN mvn clean package

#pull base image
FROM openjdk:17-oracle AS RUN_CONTAINER
COPY --from=BUILD_CONTAINER /app/target/ecommerce-backend-0.0.1-SNAPSHOT.jar /data/ecommerce-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/data/ecommerce-backend-0.0.1-SNAPSHOT.jar"]
