package dev.phquartin.storesalescleanapi.infra.mapper.product;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.infra.mapper.category.CategoryEntityMapper;
import dev.phquartin.storesalescleanapi.infra.persistence.category.CategoryEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    private final CategoryEntityMapper categoryEntityMapper;
    public ProductEntityMapper(CategoryEntityMapper categoryEntityMapper) {
        this.categoryEntityMapper = categoryEntityMapper;
    }

    public Product toDomain(ProductEntity productEntity) {
        Category category = categoryEntityMapper.toDomain(productEntity.getCategory());
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                category,
                productEntity.getPrice(),
                productEntity.getStock(),
                productEntity.getImgUrl(),
                productEntity.getDescription(),
                productEntity.getMeasureUnit()
        );
    }

    public ProductEntity toEntity (Product product){
        CategoryEntity category = categoryEntityMapper.toEntity(product.category());
        return ProductEntity.builder()
                .code(product.code())
                .name(product.name())
                .category(category)
                .price(product.price())
                .stock(product.stock())
                .imgUrl(product.imgUrl())
                .description(product.description())
                .measureUnit(product.measureUnit())
                .build();
    }

}
