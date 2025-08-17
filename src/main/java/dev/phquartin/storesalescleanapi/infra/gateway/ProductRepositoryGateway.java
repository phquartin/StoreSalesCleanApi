package dev.phquartin.storesalescleanapi.infra.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.core.gateway.ProductGateway;
import dev.phquartin.storesalescleanapi.infra.exception.DataNotFoundException;
import dev.phquartin.storesalescleanapi.infra.mapper.product.ProductEntityMapper;
import dev.phquartin.storesalescleanapi.infra.persistence.category.CategoryEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.category.CategoryRepository;
import dev.phquartin.storesalescleanapi.infra.persistence.product.ProductEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.product.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ProductEntityMapper mapper;

    public ProductRepositoryGateway(ProductRepository repository, ProductEntityMapper mapper, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product create(Product product) {

        String name = product.category().name();
        CategoryEntity byName = categoryRepository.findByName(name).orElseThrow(() -> new DataNotFoundException("Categoria " + name + " nao encontrada!"));
        ProductEntity productEntity = mapper.toEntity(product);
        productEntity.setCategory(byName);

        return mapper.toDomain(
                repository.save(
                        productEntity
                )
        );
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
