# Spring Boot User-Role API

## 📌 Project Overview

This project is a REST API built using Spring Boot that manages Users and Roles.
It allows assigning roles to users and retrieving user-role relationships.

---

## ⚙️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 📁 Project Structure

src/main/java/com/example/demo/

* entity → User, Role
* repository → UserRepository, RoleRepository
* controller → HelloController
* config → SecurityConfig

---

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO.git
cd YOUR_REPO
```

2. Run the project:

```bash
mvn spring-boot:run
```

3. Server will start at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 🔹 Get All Users

GET /users

### 🔹 Assign Role to User

POST /users/{userId}/assign-role/{roleId}

### 🔹 Get All Roles

GET /roles

---

## 🧠 Key Features

* Create and manage users
* Create and manage roles
* Assign roles to users
* Many-to-Many relationship handling

---

## ⚠️ Notes

* Ensure database is running before starting the app
* Update application.properties with correct DB config

---

## 📌 Future Improvements

* Add authentication (JWT)
* Add validation
* Add exception handling
* Add Swagger documentation

---

## 👨‍💻 Author

Abhay (ZxLoneWOLF)
