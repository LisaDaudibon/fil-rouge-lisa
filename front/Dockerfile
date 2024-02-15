FROM nginx:alpine

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY ./src/main/resources/static /usr/share/nginx/html

EXPOSE 8888:80