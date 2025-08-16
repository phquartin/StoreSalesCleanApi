package dev.phquartin.storesalescleanapi.core.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Product;

public interface ProductGateway {

    Product create(Product product);

}
