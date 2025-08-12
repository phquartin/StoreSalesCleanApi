-- Adicionar Unidades de Medida ao Produto

ALTER TABLE tb_products
ADD unit_of_measure VARCHAR(255) NOT NULL;