CREATE TABLE IF NOT EXISTS payments (
                                        id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                        order_id BIGINT UNSIGNED NOT NULL,
                                        customer_id BIGINT UNSIGNED NOT NULL,
                                        amount DECIMAL(10,2) NOT NULL,
                                        payment_method ENUM('credit_card', 'paypal', 'stripe', 'paystack') NOT NULL,
                                        status ENUM('pending', 'completed', 'failed') DEFAULT 'pending',
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                                        FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE
);
