# OTP-Generator

# 🔐 OTP Generator Application (Java | Spring Boot)

A secure OTP (One-Time Password) generation and verification system built using **Java and Spring Boot**.  
The application generates a time-bound OTP and sends it to users via **Email (SMTP)** and **SMS (Fast2SMS)**.

---

## 🚀 Features
- Generate 6-digit secure OTP
- OTP expiry and one-time validation
- Send OTP via Email
- Send OTP via SMS (Fast2SMS)
- RESTful APIs
- Clean layered architecture
- Tested using Postman

---

## 🛠️ Technologies Used
- Java
- Spring Boot
- REST API
- SMTP (Email)
- Fast2SMS API
- Maven
- Postman

---

## 📁 Project Structure
otp-generator
┣ src/main/java/com/example/otp_generator
┃ ┣ Controller
┃ ┣ Service
┃ ┣ DTO
┃ ┣ Util
┃ ┗ Exception
┣ src/main/resources
┃ ┣ application.properties (ignored)
┃ ┗ application.properties.example
┗ pom.xml
---

## 🔑 Configuration
Sensitive information like **email credentials and SMS API keys** are stored in  
`application.properties`, which is ignored using `.gitignore`.

 
## POST /api/otp/send
```json
{
  "email": "user@example.com",
  "mobile": "9876543210"
}


````

### Verify OTP

```
POST /api/otp/verify
```

```json
{
  "email": "user@example.com",
  "otp": "123456"
}
```

## ▶️ How to Run the Project

1. Clone the repository
2. Create `application.properties` from example file
3. Add your Email & SMS credentials
4. Run:

```
mvn spring-boot:run
```

## 🎯 Use Cases

* User authentication
* Password reset
* Email/Mobile verification
* Secure login systems

---

## 👩‍💻 Author

**Priyanka Rode**
Java Full Stack Developer

---

## 📜 License

This project is for learning and educational purposes.

```
