CREATE TABLE IF NOT EXISTS  deliveries (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            order_id BIGINT UNSIGNED NOT NULL,
                            deliveryman_id BIGINT UNSIGNED NULL,
                            third_party_service VARCHAR(100) NULL,
                            status ENUM('pending', 'out for delivery', 'delivered') DEFAULT 'pending',
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                            FOREIGN KEY (deliveryman_id) REFERENCES users(id) ON DELETE SET NULL
);
