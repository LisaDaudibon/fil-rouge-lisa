# Use an official Maven image as the base image
FROM openjdk:21
MAINTAINER baeldung.com
COPY target/les-amis-de-la-maison-du-vin-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]