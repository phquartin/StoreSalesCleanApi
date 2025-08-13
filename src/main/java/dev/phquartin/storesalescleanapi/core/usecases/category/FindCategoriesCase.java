package dev.phquartin.storesalescleanapi.core.usecases.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;

import java.util.List;

public interface FindCategoriesCase {

    List<Category> execute();

}
