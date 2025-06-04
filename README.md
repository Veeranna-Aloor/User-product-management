# User-product-management
Microservices Project - User & Product Management System
This project is built using a microservices architecture where each service has a specific responsibility. The services can scale independently and communicate with each other using REST APIs. Here's how the system works:
________________________________________
🔹 1. Eureka Server (Service Discovery)
•	Acts as a central registry where all other services register.
•	Helps services find and communicate with each other dynamically.
•	For example, the User Service can find the Product Service using its name, not a hardcoded URL.
________________________________________
🔹 2. User Service
•	Handles everything related to users:
o	Creating users
o	Retrieving user information
•	Uses Spring Boot for development and Spring Data JPA for database operations.
•	Includes:
o	REST APIs for user operations
o	Exception handling to manage errors cleanly
________________________________________
🔹 3. Product Service
•	Manages products:
o	Adding new products
o	Viewing product details
•	Like the User Service, it uses Spring Boot and connects to a database.
•	Exposes REST APIs to interact with product data
•	Includes:
o	Business logic (service layer)
o	Database logic (repository layer)
o	Exception handling
________________________________________
🔁 How They Work Together
•	All services are independent, but they register with the Eureka Server.
•	This allows them to communicate with each other easily using service names.
•	For example, the User Service could call the Product Service to fetch product data related to a user.
•	The system is built in a modular and scalable way, making it easier to maintain and deploy each part independently.

________________________________________
Detailed Summary:
This microservices-based project is a modular system composed of three core services: Eureka Server, User Service, and Product Service. The Eureka Server acts as a service registry, allowing other microservices to register and discover each other dynamically without hardcoded URLs. The User Service manages user-related operations such as creating and retrieving user information, while the Product Service handles product-related tasks like adding and fetching product details. Both services are built using Spring Boot and Spring Data JPA, and they expose REST APIs for communication. Each service is independently deployable, supports exception handling, and is registered with Eureka, enabling seamless interaction between services. This architecture enhances scalability, maintainability, and flexibility in deployment.
