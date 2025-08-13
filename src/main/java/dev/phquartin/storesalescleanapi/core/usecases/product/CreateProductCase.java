package dev.phquartin.storesalescleanapi.core.usecases.product;

import dev.phquartin.storesalescleanapi.core.domain.Product;

public interface CreateProductCase {

    Product execute(Product product);

}
