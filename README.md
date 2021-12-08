# <span style="font-family: Calibri; font-size: 2.8em;"> Spring Boot : College Management System </span>
## <span style="font-family: Calibri; font-size: 2.8em;"> Pre-Requisite </span>
    1. Docker Installation.

    2. Any of your favorite IDE.

## <span style="font-family: Calibri; font-size: 2.8em;"> Steps to Run the application </span>
    1. Clone the repository and checkout to master branch.

    2. Run the below Docker Commands. (Run the docker commands while being inside the project)

## <span style="font-family: Calibri; font-size: 2.8em;"> Docker Commands </span>
    1. docker-compose up --build : Since you are using the project 1st time, run this command to install all dependencies.

#### <span style="font-family: Calibri; font-size: 2.8em;"> Note : Run the command "docker-compose up" from 2nd time after above steps is successfully executed. </span>


    2. docker-compose down : Stopping all the running containers which are getting executed in above 1st step.

## <span style="font-family: Calibri; font-size: 2.8em;"> Verification (You can also skip this part!!)</span>
### <span style="font-family: Calibri; font-size: 2.8em;"> We need to verify whether the above docker commands are executed successfully or not. </span>
### <span style="font-family: Calibri; font-size: 2.8em;"> A. DB Verification </span>
#### <span style="font-family: Calibri; font-size: 2.8em;"> Run the below command to check if the database and student table are successfully created.</span>
        1. docker exec -it mysql_container_name mysql -uroot -p (where “root” is the username for MySQL database. After running above command it will ask you a password)
        2. show databases;
        3. use CollegeManagement;
        4. show tables;

### <span style="font-family: Calibri; font-size: 2.8em;"> B. Application Startup Verification </span>
#### <span style="font-family: Calibri; font-size: 2.8em;"> Use the below Swagger link to check if the application is getting successfully started.</span>
        URL - http://localhost:8084/swagger-ui.html

#### <span style="font-family: Calibri; font-size: 2.8em;"> Note : You can either use postman or swagger to test the APIs manually. </span>

## <span style="font-family: Calibri; font-size: 2.8em;"> Please share your valuable feedbacks. Thanks !! </span>