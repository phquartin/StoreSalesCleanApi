package dev.phquartin.storesalescleanapi.core.usecases.product;

import dev.phquartin.storesalescleanapi.core.domain.Product;
import dev.phquartin.storesalescleanapi.core.gateway.ProductGateway;

import java.util.List;

public class FindProductsCaseImpl implements FindProductsCase {

    private final ProductGateway gateway;
    public FindProductsCaseImpl(ProductGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Product> execute() {
        return gateway.findAll();
    }
}
