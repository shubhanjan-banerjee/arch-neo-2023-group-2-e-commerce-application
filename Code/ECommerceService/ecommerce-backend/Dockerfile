# Maven build container 
FROM maven:3.8.3-openjdk-17 AS BUILD_CONTAINER
ARG APP_DIR=app
WORKDIR ${APP_DIR}
COPY .. .
RUN mvn package


#pull base image
FROM openjdk:17-oracle AS RUN_CONTAINER
VOLUME /tmp
COPY --from=BUILD_CONTAINER ${APP_DIR}/target/ecommerce-backend-0.0.1-SNAPSHOT.jar /ecommerce-backend-0.0.1-SNAPSHOT.jar
COPY wait-for-mysql.sh /wait-for-mysql.sh
RUN chmod +x /wait-for-mysql.sh
EXPOSE 8080
RUN ls
RUN pwd
ENTRYPOINT ["/wait-for-mysql.sh"]
CMD ["java","-jar","/ecommerce-backend-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java","-jar", "./ecommerce-backend-0.0.1-SNAPSHOT.jar"]
