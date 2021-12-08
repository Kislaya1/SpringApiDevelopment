#
# Build Stage
#
FROM maven:3.8-openjdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package Stage
#
FROM openjdk:8
COPY --from=build /home/app/target/CollegeManagement.jar .
EXPOSE 8084
ENTRYPOINT ["java","-jar","CollegeManagement.jar"]