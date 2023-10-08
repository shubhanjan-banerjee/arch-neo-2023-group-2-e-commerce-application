### Docker Container

#### ECommerce Database

- `docker build -t shubhanjanweb/ecommerce-database-image .`
- `docker run --env MYSQL_ROOT_PASSWORD=root-password --net ecommerce-network --name ecommerce-database-container -d -p 3306:3306/tcp shubhanjanweb/ecommerce-database-image:latest`

#### ECommerce Baskend REST API Service

- `docker build -t shubhanjanweb/ecommerce-backend-image .`
- `docker run --env spring.datasource.url=jdbc:mysql://ecommerce-database-container:3306/ecommerce?useSSL=false --net ecommerce-network --name ecommerce-backend-container -d -p 8080:8080/tcp shubhanjanweb/ecommerce-backend-image:latest`

#### ECommerce Web UI in Angular

- `docker build -t shubhanjanweb/ecommerce-web-image .`
- `docker run --env API_BASE_URL=http://localhost:8080 --net ecommerce-network --name ecommerce-web-container -d -p 4200:80/tcp shubhanjanweb/ecommerce-web-image:latest`

### Docker compose

- `docker compose up`
