FROM java:8-jre
MAINTAINER Hector Polanco <hectornet80@gmail.com>

ADD ./target/crud-api.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/crud-api.jar"]

EXPOSE 8080
