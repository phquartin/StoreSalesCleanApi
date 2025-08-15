package dev.phquartin.storesalescleanapi.infra.configuration;

import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;
import dev.phquartin.storesalescleanapi.core.gateway.ProductGateway;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCase;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCaseImpl;
import dev.phquartin.storesalescleanapi.core.usecases.category.FindCategoriesCase;
import dev.phquartin.storesalescleanapi.core.usecases.category.FindCategoriesCaseImpl;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCase;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Category

    @Bean
    public CreateCategoryCase createCategoryCase(CategoryGateway gateway) {
        return new CreateCategoryCaseImpl(gateway);
    }

    @Bean
    public FindCategoriesCase findCategoriesCase(CategoryGateway gateway) {
        return new FindCategoriesCaseImpl(gateway);
    }

    // Product

    @Bean
    public CreateProductCase createProductCase(ProductGateway gateway) {
        return new CreateProductCaseImpl(gateway);
    }

}
