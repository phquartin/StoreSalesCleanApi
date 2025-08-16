package dev.phquartin.storesalescleanapi.infra.presentation;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCase;
import dev.phquartin.storesalescleanapi.core.usecases.product.FindProductsCase;
import dev.phquartin.storesalescleanapi.infra.mapper.product.ProductMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.ProductRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductCase createProductCase;
    private final FindProductsCase findProductsCase;
    private final ProductMapper mapper;
    public ProductController(CreateProductCase createProductCase, ProductMapper mapper, FindProductsCase findProductsCase) {
        this.createProductCase = createProductCase;
        this.mapper = mapper;
        this.findProductsCase = findProductsCase;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        Product execute = createProductCase.execute(mapper.toDomain(request));
        ProductResponse response = mapper.toResponse(execute);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        List<Product> execute = findProductsCase.execute();
        List<ProductResponse> list = execute.stream().map(mapper::toResponse).toList();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

}
