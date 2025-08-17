package dev.phquartin.storesalescleanapi.infra.mapper.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.infra.persistence.category.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityMapper {

    public CategoryEntity toEntity(Category category) {
        return CategoryEntity.builder()
                .id(category.id())
                .name(category.name())
                .build();
    }

    public Category toDomain(CategoryEntity categoryEntity){
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName()
        );
    }

}
