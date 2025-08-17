package dev.phquartin.storesalescleanapi.infra.persistence.sale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.phquartin.storesalescleanapi.infra.persistence.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_sale_itens")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleItensEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code", nullable = false)
    private ProductEntity product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    @JsonIgnore
    private SaleEntity sale;
}
