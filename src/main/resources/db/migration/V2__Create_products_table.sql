CREATE TABLE IF NOT EXISTS  products (
                          id SERIAL PRIMARY KEY,
                          farmer_id BIGINT NOT NULL,
                          name VARCHAR(255) NOT NULL,
                          category ENUM('vegetable', 'fruit', 'grain', 'dairy', 'meat') NOT NULL,
                          price DECIMAL(10,2) NOT NULL,
                          quantity INT NOT NULL,
                          status ENUM('available', 'out of stock') DEFAULT 'available',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (farmer_id) REFERENCES users(id) ON DELETE CASCADE
);
