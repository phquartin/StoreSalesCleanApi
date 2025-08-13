package dev.phquartin.storesalescleanapi.core.usecases.product;

import dev.phquartin.storesalescleanapi.core.domain.Product;

import java.util.List;

public interface FindProductsCase {

    List<Product> execute();

}
