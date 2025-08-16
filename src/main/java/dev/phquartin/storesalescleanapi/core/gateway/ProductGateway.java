package dev.phquartin.storesalescleanapi.core.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Product;

import java.util.List;

public interface ProductGateway {

    Product create(Product product);

    List<Product> findAll();

}
