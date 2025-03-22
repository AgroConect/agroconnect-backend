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
spring.datasource.url=jdbc:mysql://localhost:3306/agroconnect
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Settings
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

# Ensure the Database is Running
# For MySQL, start the MySQL server:
sudo systemctl start mysql  # Linux
net start MySQL80           # Windows

# If you haven't created the database yet, do it manually:
CREATE DATABASE agroconnect;

# 3️⃣ Add the Required JDBC Driver
# Ensure the JDBC driver dependency is added in your pom.xml:

# For MySQL:
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

# Flyway Migationn for the Database
# Flyway Dependecies
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

# Add this to application.properties
# Enable Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true

#Migrate manually
mvn flyway:migrate  # For Maven projects
./gradlew flywayMigrate  # For Gradle projects


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
