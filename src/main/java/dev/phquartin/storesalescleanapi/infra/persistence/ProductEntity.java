package dev.phquartin.storesalescleanapi.infra.persistence;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "tb_products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(length = 150, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "img_url", length = 1000)
    private String imgUrl;

    private String description;
}
