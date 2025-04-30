-- Step 5: Create the Deliveries Table
CREATE TABLE IF NOT EXISTS deliveries (
                                          id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                          order_id BIGINT UNSIGNED NOT NULL,
                                          deliveryman_id BIGINT UNSIGNED NULL,
                                          third_party_service TEXT NULL,
                                          status ENUM('PENDING', 'OUT_FOR_DELIVERY', 'DELIVERED') DEFAULT 'PENDING',
                                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                          FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                                          FOREIGN KEY (deliveryman_id) REFERENCES users(id) ON DELETE SET NULL,
                                          INDEX (order_id),
                                          INDEX (deliveryman_id)
);