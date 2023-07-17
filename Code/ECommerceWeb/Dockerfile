FROM node:alpine3.15 as BUILD
WORKDIR /app
COPY . .
RUN npm install -g nx
RUN npm install
RUN npm run build

FROM nginx
EXPOSE 80
COPY --from=BUILD /app/dist/ecommerce /usr/share/nginx/html
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
# CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env.template.js > /usr/share/nginx/html/assets/env.js && exec nginx -g 'daemon off;'"]
