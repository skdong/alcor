# Dockerfile for VPC Manager

FROM openjdk:8

MAINTAINER Zhonghao Lyu <zlyu@futurewei.com>

# VPC Manager process
EXPOSE 8080
# VPC Manager admin process

# Generate container image and run container
COPY ./target/vpc_manager-0.1.0-SNAPSHOT.jar /app/vpc_manager-0.1.0.jar
#COPY ./config/machine.json /app/config/machine.json

CMD ["java", "-jar", "/app/vpc_manager-0.1.0.jar"]

