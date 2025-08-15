package dev.phquartin.storesalescleanapi.core.usecases.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;

public class CreateCategoryCaseImpl implements CreateCategoryCase {

    private final CategoryGateway gateway;
    public CreateCategoryCaseImpl(CategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Category execute(Category category) {
        return gateway.create(category);
    }
}
