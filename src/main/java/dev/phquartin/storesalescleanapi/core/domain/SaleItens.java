package dev.phquartin.storesalescleanapi.core.domain;


public class SaleItens{
        private Long id;
        private Product product;
        private int quantity;
        private Double price;
        private Sale sale;

        public SaleItens(Long id, Product product, int quantity, Sale sale) {
                this.id = id;
                this.product = product;
                this.quantity = quantity;
                this.sale = sale;
                this.price = calculateParcialValue();
        }


        private Double calculateParcialValue() {
                return this.quantity * this.product.price();

        }

        public Long getId() {
                return id;
        }

        public Product getProduct() {
                return product;
        }

        public int getQuantity() {
                return quantity;
        }

        public Double getPrice() {
                return price;
        }

        public Sale getSale() {
                return sale;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }

        public void setPrice(Double price) {
                this.price = price;
        }

        public void setSale(Sale sale) {
                this.sale = sale;
        }
}
