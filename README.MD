## appActivitats-PruebaHackaton

<hr>

### Table of contents

1. [Description](#description)
2. [Usage](#usage)
3. [Installation](#installation)
    1. [Required programs](#required-programs)
    2. [Project links](#project-links)
    3. [Procedure](#procedure)
       1.[Procedure with Gradle](#procedure-with-gradle)
       2.[Procedure with Docker](#procedure-with-docker)
   

<hr>

### Description

The appActivitats-PruebaHackaton project is built using Java with the Spring Boot framework. It is an initiative designed to manage users and activities, providing a comprehensive API for various operations.

The primary goal is to provide a robust backend service for managing user registrations, activity management, and data import/export in JSON format.

This project exists thanks to all the people who contribute.

**For newcomers**, we strongly emphasize the importance of thoroughly reading the entire README. This document contains crucial information about installation, configuration, and daily processes necessary for effectively working on this project.

### Usage

This project provides REST API services for managing users and activities. Each service exposes REST APIs to interact with it. To use any service, you can refer to the [procedure](#procedure) section or start it from the App class in your IDE.

### Installation

#### Required programs

It is important to make sure you have all these tools installed and configured correctly before you start working on the project.

- **Java SE Development Kit 21**
- **Gradle 6.0 or higher**
- **IntelliJ IDEA 2024.1.4 (or any other preferred IDE)**
- **Docker**
- **Postman**
- **MongoDB**


#### Project links

- [GitHub](https://github.com/danidiazd/appActivitats). The source code.
- [Swagger](http://localhost:8080/swagger). The API documentation.

#### Procedure

1. Install the required software listed in the "Required programs" and "Project links" sections.


2. Make sure you have Docker Desktop turned on.


3. Start MongoDB and create the database. (If you use Docker skip that point.)
 - Open a terminal and start the MongoDB server:
 ```sh
 - mongod
 ```

- Open another terminal and connect to the MongoDB server:
```sh
- mongo
```
 - Create the database:
 ```sh
    - use appActivitats
 ```  
- Create the collections:
 ```sh
    - db.createCollection("users")
    - db.createCollection("activities")
 ```


4. Clone the repository:
   ```sh
   git clone https://github.com/danidiazd/appActivitats.git
    ```
5. Navigate into the project directory:
   ```sh
   cd appActivitats\appActivitats\
   ```
      ##### Procedure with Gradle
         
   6. Build the project:
      ```sh
      gradle build
      ```
      if you are using Windows, you can use the following command:
      ```sh
       ./gradlew build
      ```
         1. Run the project:
      ```sh
      gradle bootRun
      ```
      if you are using Windows PowerShell, Linux you can use the following command:
      ```sh
       ./gradlew bootRun
      ```
   
      ##### Procedure with Docker
      1. Build the project:
         ```sh
          gradle build
          ```
       if you are using Windows PowerShell or Linux, you can use the following command:
       ```sh
        ./gradlew build
        ```

      2. Build and run the Docker compose file:
            ```sh
              docker-compose up --build
            ```

7. Open your browser and navigate to [Swagger](http://localhost:8080/swagger) to view the API documentation.


8. Use Postman to test the API endpoints.

##### Import the Postman collection from the following path:

```sh
    appActivitats/src/main/resources/postman/appActivitats.postman_collection.json
```
9. To stop the project, press `Ctrl + C` in the terminal.



 









