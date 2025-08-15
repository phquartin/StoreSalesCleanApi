package dev.phquartin.storesalescleanapi.core.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Category;

import java.util.List;

public interface CategoryGateway {

    Category create(Category category);

    List<Category> findAll();
}
