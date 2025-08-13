package dev.phquartin.storesalescleanapi.infra.presentation;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCase;
import dev.phquartin.storesalescleanapi.infra.mapper.CategoryMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.CategoryRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CreateCategoryCase createCategoryCase;
    private final CategoryMapper categoryMapper;

    public CategoryController(CreateCategoryCase createCategoryCase, CategoryMapper categoryMapper) {
        this.createCategoryCase = createCategoryCase;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        Category category = createCategoryCase.execute(categoryMapper.toDomain(request));
        CategoryResponse response = categoryMapper.toResponse(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
