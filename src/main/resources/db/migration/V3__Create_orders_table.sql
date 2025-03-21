CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                      customer_id BIGINT UNSIGNED NOT NULL,
                                      product_id BIGINT UNSIGNED NOT NULL,
                                      quantity INT NOT NULL,
                                      total_price DECIMAL(10,2) NOT NULL,
                                      status ENUM('pending', 'processing', 'shipped', 'delivered') DEFAULT 'pending',
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE,
                                      FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);
