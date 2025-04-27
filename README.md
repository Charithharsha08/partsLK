
---

# 🚗 PartsLK Vehicle Spare Part Hub 🔧⚙️  
Your go-to platform for buying and selling vehicle spare parts – inspired by **ikman.lk**, but laser-focused on the auto industry.

This platform enables individuals and store owners to create personalized profiles, set up online spare parts shops, manage inventory, and provide customers with a smooth purchasing experience.

---

## 🚀 Live Demo  
[🎥 Watch on YouTube]([[https://youtu.be/ycEjn3y3lZw](https://youtu.be/iQRPL8qC9t0?si=DDOdV8_tvxvQS8Cr)]](https://youtu.be/iQRPL8qC9t0?si=_1Es3Lpj18DHQfq3))

---

## 🌟 Features

### 🧑‍💼 **User Panel**
- **Profile Management** – Create your account, update details, and track your activity.
- **Store Creation** – Open your own digital vehicle parts store.
- **Product Management** – Add, update, and delete products with ease.
- **Order Management** – View incoming orders and manage customer purchases.
- **Secure Authentication** – JWT-based login and registration flow.

### 🛒 **Customer Experience**
- **Browse Products** – Explore a wide variety of vehicle parts.
- **Search & Filter** – Quickly find what you need by category, brand, or price.
- **Buy Online** – Smooth checkout with integrated payment options.
- **Contact Store Owners** – Chat or call directly from the platform.

---

## 🧱 Tech Stack

| Layer       | Technology                              |
|-------------|------------------------------------------|
| Frontend    | Bootstrap 5, HTML5, CSS3, JavaScript, AJAX |
| Backend     | Spring Boot (MVC + REST), Spring Data JPA |
| Database    | MySQL                                    |
| Auth        | JWT (JSON Web Token)                     |
| Payment     | Direct Bank Transfer

---

## 📸 Screenshots


### 🏠 Homepage  
Modern layout showcasing top categories and featured products.


<img width="1680" alt="Screenshot 2025-04-22 at 6 04 47 PM" src="https://github.com/user-attachments/assets/d3f295e7-76e7-4bce-8f72-ab965e08986d" />

### 🛍️ Storefront & Product Listings  
User-managed stores with customizable inventory.

<img width="1680" alt="Screenshot 2025-04-22 at 6 11 31 PM" src="https://github.com/user-attachments/assets/cc442f2e-0541-4e1c-be37-2678cac29f64" />


### 🧾 Product Details  
Rich product descriptions, pricing, and condition info.

<img width="1680" alt="Screenshot 2025-04-22 at 6 13 32 PM" src="https://github.com/user-attachments/assets/01da4185-72bd-4592-817e-7ac4565023da" />


### 💳 Checkout & Payment  

<img width="1680" alt="Screenshot 2025-04-22 at 6 14 13 PM" src="https://github.com/user-attachments/assets/752df32d-1148-4cfe-a93a-ce13583701d8" />


### 🧑‍💻 User Profile & Dashboard  
Manage stores, orders, and account details.

<img width="1680" alt="Screenshot 2025-04-22 at 6 19 07 PM" src="https://github.com/user-attachments/assets/2bf607c6-7e3e-4611-b2cb-fdcadf02748e" />

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository  
```bash
git clone [https://github.com/YourUsername/Vehicle-Spare-Part-Hub.git](https://github.com/Charithharsha08/partsLK.git)
```

### 2️⃣ Create MySQL Database  
```sql
CREATE DATABASE partslk;
```

### 3️⃣ Configure `application.properties`
```properties
spring.application.name = VehicleSparePartHub
spring.datasource.url = jdbc:mysql://localhost:3306/vehicle_spare_part_hub?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username = root
spring.datasource.password = yourPassword
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.open-in-view = false
spring.jpa.show-sql = true
spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver

jwt.secret = yourJWTSecretKey
server.port = 8080

# HikariCP Settings
spring.datasource.hikari.maximum-pool-size = 20
spring.datasource.hikari.minimum-idle = 5
spring.datasource.hikari.idle-timeout = 30000
spring.datasource.hikari.max-lifetime = 1800000
spring.datasource.hikari.connection-timeout = 30000

# Mail Configuration
spring.mail.host = smtp.gmail.com
spring.mail.port = 587
spring.mail.username = yourEmail
spring.mail.password = yourEmailPassword
spring.mail.properties.mail.smtp.auth = true
spring.mail.properties.mail.smtp.starttls.enable = true
```

---

## 👨‍💻 Developed By  
**Charith Harsha**  
Aspiring Software Engineer | IJSE | Galle 🌴  
📍 Sri Lanka

[💻 GitHub Profile](https://github.com/Charithharsha08)

---
