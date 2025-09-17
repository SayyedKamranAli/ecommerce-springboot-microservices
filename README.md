# Ecommerce Spring Boot Microservices Project

## Overview
This project demonstrates a **Microservices-based architecture** using **Java 17** and **Spring Boot**.  
It follows modular design principles with **API Gateway**, **Authentication**, and business-specific services.

---

## Microservices in this Project

1. **API Gateway**
   - Single entry point for all requests
   - Routes requests to services
   - Handles CORS, logging, and security

2. **Auth Service**
   - User authentication & authorization
   - **JWT-based security**
   - Login & Signup endpoints

3. **Category Service**
   - Manages product categories
   - CRUD operations for categories
   - Independent database

4. **Product Service**
   - Handles product management
   - CRUD APIs for products
   - Linked with Category Service

---

## Tech Stack
- **Java 17**
- **Spring Boot**
- **Spring Cloud Gateway**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **MySQL / PostgreSQL**
- **Maven**

---

## Project Structure
```
springboot-microservices/
│── api-gateway/
│   ├── src/
│   └── pom.xml
│
│── auth-service/
│   ├── src/
│   └── pom.xml
│
│── category-service/
│   ├── src/
│   └── pom.xml
│
│── product-service/
│   ├── src/
│   └── pom.xml
│
└── README.md
```

---

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/SayyedKamranAli/ecommerce-springboot-microservices
cd ecommerce-springboot-microservices
```

### Build & Run Services
Run each service independently:
```bash
cd api-gateway
mvn spring-boot:run
```
(Same for `auth-service`, `category-service`, `product-service`)

### Service Endpoints
- API Gateway → `http://localhost:8080`
- Auth Service → `http://localhost:8081/auth`
- Category Service → `http://localhost:8082/categories`
- Product Service → `http://localhost:8083/products`

---

## Authentication Flow
1. User registers/logs in via **Auth Service**
2. Auth Service issues a **JWT token**
3. API Gateway validates JWT before routing requests
4. Other services accept only valid tokens

---

## Future Enhancements
- Service Discovery (**Eureka**)
- Centralized Config Server
- **Docker & Kubernetes** deployment
- API Documentation (**Swagger/OpenAPI**)

---

## Contributing
Contributions, issues, and feature requests are welcome!  
Feel free to fork this repo and submit a pull request.

---

## Author
**Sayyed Kamran Ali**  
🔗 [GitHub Profile](https://github.com/SayyedKamranAli)
