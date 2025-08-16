package dev.phquartin.storesalescleanapi.core.usecases.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;

public class FindCategoryByNameCaseImpl implements FindCategoryByNameCase{

    private final CategoryGateway gateway;
    public FindCategoryByNameCaseImpl(CategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Category execute(String name) {
        return gateway.findByName(name);
    }
}
