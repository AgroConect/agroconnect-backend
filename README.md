# 🌱 AgroConnect

AgroConnect is a platform that connects farmers directly with customers, eliminating middlemen. Farmers can sell produce, shop for discounted farm machinery, and access weather forecasts to optimize farming decisions. 🚜🌾

## 📖 AgroConnect Backend Documentation (Spring Boot)

🚀 **AgroConnect Backend** is a Spring Boot-powered REST API that facilitates seamless communication between farmers and agricultural experts.

---

## 📌 Getting Started

### 1️⃣ Prerequisites

Ensure you have the following installed on your machine:

- **Java 17+** (Check version using `java -version`)
- **Maven** (Check version using `mvn -version`)
- **PostgreSQL/MySQL** (For database storage)
- **Git** (For version control)
- **Postman** (For testing APIs - optional)

---

## 📦 Project Setup

### 2️⃣ Clone the Repository

To get a local copy of AgroConnect Backend, run the following command in your terminal:

```sh
# Clone the Repository
git clone https://github.com/AgroConect/agroconnect-backend.git
cd agroconnect-backend

# 3️⃣ Install Dependencies
#This project uses Maven to manage dependencies. Install them using:

mvn clean install

# 4️⃣ Configure Environment Variables
# Create an .env file or update application.properties:

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/agroconnect
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

# Server Configuration
server.port=8080

# JWT Configuration
jwt.secret=your_jwt_secret
jwt.expiration=3600000

# 🚀 Running the Application
# To start the Spring Boot application, run:
mvn spring-boot:run
# The backend will be available at http://localhost:8080.

# 👥 Contributing
# Before making changes, always pull the latest updates:
git pull origin main

# 1️⃣ Create a New Branch
# For a new feature or bug fix, create a separate branch:
git checkout -b feature-branch-name

# 2️⃣ Make Changes and Commit
# After modifying code, stage changes:
git add .
git commit -m "Added authentication system"

# 3️⃣ Push Changes & Create a Pull Request
git push origin feature-branch-name
# Then, create a Pull Request (PR) on GitHub to merge your changes.

```

## 🐞 Debugging & Logs

Spring Boot logs are visible in the terminal.
For more detailed debugging, check logs in /logs/app.log.

## 📜 License

This project is licensed under the MIT License.

## 🤝 Contributors

Thanks to all contributors for making this project possible! 💪

Muhammedfuad Bashar
Uthman Ipadeola
Saheed Tijani
