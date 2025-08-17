CREATE TABLE tb_sale_itens (
                             id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                             product_code BIGINT UNSIGNED NOT NULL,
                             price DECIMAL(10,2) NOT NULL,
                             quantity INTEGER NOT NULL,
                             sale_id BIGINT UNSIGNED NOT NULL,
                             FOREIGN KEY (product_code) REFERENCES tb_products(code),
                             FOREIGN KEY (sale_id) REFERENCES tb_sales(id)
)