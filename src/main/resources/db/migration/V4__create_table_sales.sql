CREATE TABLE tb_sales (
                id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                payment_method VARCHAR(255) NOT NULL,
                total_value DECIMAL(10,2) NOT NULL,
                date_time DATETIME NOT NULL
)