# Spring Boot CRUDs-example

This project is a Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations on a User
model with custom validation checks in a MySQL database.

## Prerequisites

Before you begin, make sure you have the following installed on your system:

- A Java Development Kit (JDK), version 17 or later
- A build tool such as Gradle (version 7.5+) or Maven (version 3.5+)
- An Integrated Development Environment (IDE) such as IntelliJ IDEA, Spring Tools, Visual Studio Code, Eclipse, or any
  other of your choice.
- MySQL Server

## Installation

To install and set up the project, follow these steps:

1. Open a command line or terminal window and navigate to the folder where you want to clone the project.

###

2. Clone the repository to your local machine using the following command:

```
git clone https://github.com/YOUR_USERNAME/spring-boot-cruds-example.git
```

###

3. Open the project in your IDE.

###

4. Copy the `application.properties.example` file to `application.properties` using the
   command `cp application.properties.example application.properties`.

###

5. Update the `application.properties` file with your MySQL database credentials and other configuration details.

###

6. Open the project in your IDE.

###

7. Copy the `application.properties.example` file to `application.properties` using the
   command `cp application.properties.example application.properties`.

###

8. Update the `application.properties` file with your MySQL database credentials and other configuration details. Here's
   an example of what the file should look like:

```
spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
server.error.include-message=always
```

###

9. Build and run the application using build tool of your choice.

```
./mvnw spring-boot:run
```

That's it! The application should now be running and available at `http://localhost:8080`. You can interact with it
using a web browser or a tool such as Postman or cURL.

Happy coding! 😊
