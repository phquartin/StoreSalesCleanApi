package dev.phquartin.storesalescleanapi.infra.mapper.product;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.infra.mapper.category.CategoryMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.ProductRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final CategoryMapper categoryMapper;
    public ProductMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Product toDomain(ProductRequest request) {
        return new Product(
                null,
                request.name(),
                categoryMapper.toDomain(request.category()),
                request.price(),
                request.stock(),
                request.imgUrl(),
                request.description(),
                request.measureUnit()
        );
    }

    public ProductResponse toResponse(Product product){
        return ProductResponse.builder()
                .code(product.code())
                .name(product.name())
                .category(product.category())
                .price(product.price())
                .stock(product.stock())
                .imgUrl(product.imgUrl())
                .description(product.description())
                .measureUnit(product.measureUnit())
                .build();
    }

}
