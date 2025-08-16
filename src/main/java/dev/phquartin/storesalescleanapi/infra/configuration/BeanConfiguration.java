package dev.phquartin.storesalescleanapi.infra.configuration;

import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;
import dev.phquartin.storesalescleanapi.core.gateway.ProductGateway;
import dev.phquartin.storesalescleanapi.core.usecases.category.*;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCase;
import dev.phquartin.storesalescleanapi.core.usecases.product.CreateProductCaseImpl;
import dev.phquartin.storesalescleanapi.core.usecases.product.FindProductsCase;
import dev.phquartin.storesalescleanapi.core.usecases.product.FindProductsCaseImpl;
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

    @Bean
    public FindCategoryByNameCase findCategoryByNameCase(CategoryGateway gateway) {
        return new FindCategoryByNameCaseImpl(gateway);
    }

    // Product

    @Bean
    public CreateProductCase createProductCase(ProductGateway gateway) {
        return new CreateProductCaseImpl(gateway);
    }

    @Bean
    public FindProductsCase findProductsCase(ProductGateway gateway) {
        return new FindProductsCaseImpl(gateway);
    }
}
