CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,  -- Changed to BIGINT
                                        farmer_id BIGINT UNSIGNED NOT NULL,    -- Kept BIGINT UNSIGNED as it references users(id)
                                        name VARCHAR(255) NOT NULL,
                                        category ENUM('vegetable', 'fruit', 'grain', 'dairy', 'meat') NOT NULL,
                                        price DECIMAL(10,2) NOT NULL,
                                        quantity INT NOT NULL,
                                        status ENUM('available', 'out of stock') DEFAULT 'available',
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (farmer_id) REFERENCES users(id) ON DELETE CASCADE
);
