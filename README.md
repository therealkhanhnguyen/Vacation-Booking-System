# Vacation Booking System (Backend)

This is the **backend API** for the Vacation Booking System — a Spring Boot RESTful service that manages travel packages, customers, orders, and destinations.

## 🔧 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## 📂 Project Structure

backend/
├── src/
│ ├── main/
│ │ ├── java/com/...
│ │ └── resources/
├── pom.xml


## 🚀 How to Run

1. Make sure MySQL is running.
2. Configure `application.properties` inside:
backend/src/main/resources/application.properties
Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vacation_booking
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
3.Build and run the project:
mvn spring-boot:run

API will be available at:
http://localhost:8080

This project includes a separate frontend built with Angular.
To access the frontend code, switch to the frontend branch
Then follow the instructions in that branch’s README to run the UI.
