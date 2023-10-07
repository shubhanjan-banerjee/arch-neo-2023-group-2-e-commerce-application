FROM mysql:8
ENV MYSQL_ROOT_PASSWORD=root-password
ENV MYSQL_DATABASE=ecommerce
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=password
COPY docker-healthcheck /usr/local/bin/
COPY init.sql /docker-entrypoint-initdb.d/01.sql
EXPOSE 3306
HEALTHCHECK CMD ["docker-healthcheck"]