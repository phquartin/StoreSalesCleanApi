package dev.phquartin.storesalescleanapi.infra.presentation;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCase;
import dev.phquartin.storesalescleanapi.core.usecases.category.FindCategoriesCase;
import dev.phquartin.storesalescleanapi.infra.mapper.category.CategoryMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.CategoryRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CreateCategoryCase createCategoryCase;
    private final FindCategoriesCase findCategoriesCase;
    private final CategoryMapper categoryMapper;

    public CategoryController(CreateCategoryCase createCategoryCase, CategoryMapper categoryMapper, FindCategoriesCase findCategoriesCase) {
        this.createCategoryCase = createCategoryCase;
        this.categoryMapper = categoryMapper;
        this.findCategoriesCase = findCategoriesCase;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        Category category = createCategoryCase.execute(categoryMapper.toDomain(request));
        CategoryResponse response = categoryMapper.toResponse(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories() {
        List<Category> categories = findCategoriesCase.execute();
        List<CategoryResponse> list = categories.stream().map(categoryMapper::toResponse).toList();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

}
