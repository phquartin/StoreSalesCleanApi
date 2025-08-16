package dev.phquartin.storesalescleanapi.core.usecases.product;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.core.gateway.ProductGateway;

public class CreateProductCaseImpl implements CreateProductCase {

    private final ProductGateway gateway;
    public CreateProductCaseImpl(ProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Product execute(Product product) {
        return gateway.create(product);
    }
}
