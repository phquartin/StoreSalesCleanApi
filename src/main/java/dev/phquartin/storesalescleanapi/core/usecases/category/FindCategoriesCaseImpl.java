package dev.phquartin.storesalescleanapi.core.usecases.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;

import java.util.List;

public class FindCategoriesCaseImpl implements FindCategoriesCase {

    private final CategoryGateway gateway;
    public FindCategoriesCaseImpl(CategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Category> execute() {
        return gateway.findAll();
    }
}
