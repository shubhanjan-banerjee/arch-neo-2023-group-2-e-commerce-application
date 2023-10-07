FROM mysql/mysql-server

COPY docker-healthcheck /usr/local/bin/
COPY ./scripts/schema.sql /docker-entrypoint-initdb.d/01.sql

EXPOSE 3306

HEALTHCHECK CMD ["docker-healthcheck"]