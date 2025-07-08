# E-Wallet Application

A simple Java Spring Boot-based e-wallet backend that allows user registration, wallet top-up, money transfers, and transaction tracking. This application uses Spring Security, JPA, and PostgreSQL.

---

## 🏗️ Project Structure

```
src/main/java
└── com
    └── arin
        ├── config               # Spring Security configuration
        ├── controller           # REST controllers for user and wallet APIs
        ├── service              # Service layer for business logic
        ├── repository           # JPA repositories for DB interaction
        └── EWalletApplication.java  # Main Spring Boot class
```

---

## 🚀 Features

- User Registration with Bcrypt password encoding
- Wallet creation and top-up
- Money transfer between wallets
- View transaction history
- Spring Security configuration for development/testing

---

## ⚙️ Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- PostgreSQL
- HikariCP (default connection pool)

---

## 🔐 Security

The app uses Spring Security with CSRF disabled for easier Postman testing. Passwords are hashed using Bcrypt.

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd e-wallet-app
```

### 2. Configure `application.properties`

Update your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ewallet
spring.datasource.username=your_pg_user
spring.datasource.password=your_pg_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the App

```bash
./mvnw spring-boot:run
```

Or use your IDE to run `EWalletApplication.java`

---

## 🧪 Example API Requests (via Postman)

### Register a New User

`POST /api/users/register`

```json
{
  "name": "Alice Sharma",
  "email": "alice@example.com",
  "password": "123456"
}
```

### Top-Up Wallet

`POST /api/wallet/topup`

```json
{
  "userId": 1,
  "amount": 10000
}
```

### Transfer Funds

`POST /api/wallet/transfer`

```json
{
  "senderId": 1,
  "receiverId": 2,
  "amount": 2000
}
```

### View Transactions

`GET /api/transactions/{userId}`

---

## 📁 Where to Place This `README.md`

Place it at the **root of your project**, i.e. the same level as your `src/` folder and `pom.xml` file.

```
.
├── README.md       ✅ <-- here
├── pom.xml
├── src/
└── ...
```

---

## 📝 License

This project is for learning purposes. No license attached.

