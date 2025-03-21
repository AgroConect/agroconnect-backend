CREATE TABLE IF NOT EXISTS weather_forecast (
                                                id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                                location VARCHAR(255) NOT NULL,
                                                temperature DECIMAL(5,2) NOT NULL,
                                                humidity DECIMAL(5,2) NOT NULL,
                                                precipitation DECIMAL(5,2) NOT NULL,
                                                forecast_date DATE NOT NULL,
                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
