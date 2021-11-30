FROM openjdk:8
EXPOSE 8084
WORKDIR /app
COPY target/CollegeManagement.jar .
ENTRYPOINT ["java","-jar","CollegeManagement.jar"]