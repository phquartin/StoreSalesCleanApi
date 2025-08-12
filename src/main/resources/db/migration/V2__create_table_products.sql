CREATE TABLE tb_products (
    code BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL UNIQUE,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    stock INTEGER NOT NULL,
    img_url VARCHAR(1000),
    category_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (category_id) REFERENCES tb_categories(id)

)