# Maven build container 
FROM maven:3.8.3-openjdk-17 AS BUILD_CONTAINER
ARG APP_DIR=app
WORKDIR ${APP_DIR}
COPY .. .
RUN mvn package


#pull base image
FROM openjdk:17-oracle AS RUN_CONTAINER
COPY --from=BUILD_CONTAINER ${APP_DIR}/target/ecommerce-backend-0.0.1-SNAPSHOT.jar /data/ecommerce-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
RUN ls
RUN pwd
# ENTRYPOINT ["java","-jar", "./target/ecommerce-backend-0.0.1-SNAPSHOT.jar"]

