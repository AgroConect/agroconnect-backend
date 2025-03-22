CREATE TABLE IF NOT EXISTS  deliveries (
                            id SERIAL PRIMARY KEY,
                            order_id BIGINT NOT NULL,
                            deliveryman_id BIGINT NULL,
                            third_party_service VARCHAR(100) NULL,
                            status ENUM('pending', 'out for delivery', 'delivered') DEFAULT 'pending',
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                            FOREIGN KEY (deliveryman_id) REFERENCES users(id) ON DELETE SET NULL
);
