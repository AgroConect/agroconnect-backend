CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('admin', 'farmer', 'customer', 'deliveryman') NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       postcode VARCHAR(20) NOT NULL,
                       phone_number VARCHAR(20) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);