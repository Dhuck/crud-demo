FROM java:8-jre
MAINTAINER Hector Polanco <hectornet80@gmail.com>

#TODO: Temporary assignment - Use of docker-compose
ENV CONFIG_SERVICE_PASSWORD=notiene

ADD ./target/crud-api.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/crud-api.jar"]

EXPOSE 8080