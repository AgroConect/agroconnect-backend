-- Step 4: Create the Payments Table
CREATE TABLE IF NOT EXISTS payments (
                                        id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                        order_id BIGINT UNSIGNED NOT NULL,
                                        customer_id BIGINT UNSIGNED NOT NULL,
                                        amount DECIMAL(10,2) NOT NULL,
                                        payment_method ENUM('CREDIT_CARD', 'PAYPAL', 'STRIPE', 'PAYSTACK') NOT NULL,
                                        status ENUM('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'PENDING',
                                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                        FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                                        FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE,
                                        INDEX (order_id),
                                        INDEX (customer_id)
);