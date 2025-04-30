-- V1__Create_Tables.sql (Flyway Migration Script)
-- Step 1: Create the Users Table
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                     firstname VARCHAR(100) NOT NULL,
                                     lastname VARCHAR(100) NOT NULL,
                                     email VARCHAR(255) UNIQUE NOT NULL,
                                     password VARCHAR(255) NOT NULL,
                                     role ENUM('ADMIN', 'FARMER', 'CUSTOMER', 'DELIVERYMAN') NOT NULL,
                                     street VARCHAR(255) NOT NULL,
                                     city VARCHAR(100) NOT NULL,
                                     state VARCHAR(100) NOT NULL,
                                     postcode VARCHAR(20) NOT NULL,
                                     phone_number VARCHAR(20) NOT NULL,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     INDEX (email)
);