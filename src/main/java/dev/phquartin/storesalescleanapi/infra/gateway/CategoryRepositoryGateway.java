package dev.phquartin.storesalescleanapi.infra.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;
import dev.phquartin.storesalescleanapi.infra.exception.DataNotFoundException;
import dev.phquartin.storesalescleanapi.infra.mapper.category.CategoryEntityMapper;
import dev.phquartin.storesalescleanapi.infra.persistence.CategoryEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.CategoryRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepositoryGateway implements CategoryGateway {
    private final CategoryRepository repository;

    private final CategoryEntityMapper mapper;
    public CategoryRepositoryGateway(CategoryRepository repository, CategoryEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cria uma nova categoria mapeando de Domain para Entity e para retornar outro mapeamento.
     *
     * @param category A representacao Domain da categoria a ser salva
     * @return Categoria salva representada pela classe Domain
     */
    @Override
    public Category create(Category category) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(category)
                )
        );
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> allCategoriesEntity = repository.findAll();
        return allCategoriesEntity.stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Category findByName(String name) {
       return mapper.toDomain(repository.findByName(name).orElseThrow(() -> new DataNotFoundException("Categoria " + name + " nao encontrada!")));
    }
}
