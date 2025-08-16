package dev.phquartin.storesalescleanapi.infra.presentation;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCase;
import dev.phquartin.storesalescleanapi.infra.mapper.product.ProductMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.ProductRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductCase createProductCase;
    private final ProductMapper mapper;
    public ProductController(CreateProductCase createProductCase, ProductMapper mapper) {
        this.createProductCase = createProductCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        Product execute = createProductCase.execute(mapper.toDomain(request));
        ProductResponse response = mapper.toResponse(execute);
        return ResponseEntity.status(201).body(response);
    }

}
