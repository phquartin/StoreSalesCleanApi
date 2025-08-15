package dev.phquartin.storesalescleanapi.infra.mapper;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.infra.presentation.request.CategoryRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toDomain(CategoryRequest request) {
        return new Category(null, request.name());
    }

    public CategoryResponse toResponse (Category entity) {
        return CategoryResponse.builder()
                .name(entity.name())
                .build();
    }

}
