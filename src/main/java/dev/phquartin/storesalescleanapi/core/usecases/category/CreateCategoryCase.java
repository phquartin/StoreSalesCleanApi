package dev.phquartin.storesalescleanapi.core.usecases.category;

import dev.phquartin.storesalescleanapi.core.domain.Category;

public interface CreateCategoryCase {

    Category execute(Category category);

}
