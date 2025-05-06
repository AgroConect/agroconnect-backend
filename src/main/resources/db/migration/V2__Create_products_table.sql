-- Step 2: Create the Products Table
CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                        farmer_id BIGINT UNSIGNED NOT NULL,
                                        name VARCHAR(255) NOT NULL,
                                        image_url VARCHAR(512),
                                        category ENUM('VEGETABLE', 'FRUIT', 'GRAIN', 'DIARY', 'MEAT') NOT NULL,
                                        price DECIMAL(10,2) NOT NULL,
                                        quantity INT NOT NULL,
                                        status ENUM('AVAILABLE', 'OUT_OF_STOCK') DEFAULT 'AVAILABLE',
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (farmer_id) REFERENCES users(id) ON DELETE CASCADE,
                                        INDEX (farmer_id)
);