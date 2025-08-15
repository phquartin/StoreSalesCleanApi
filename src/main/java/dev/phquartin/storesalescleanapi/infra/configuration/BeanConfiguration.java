package dev.phquartin.storesalescleanapi.infra.configuration;

import dev.phquartin.storesalescleanapi.core.gateway.CategoryGateway;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCase;
import dev.phquartin.storesalescleanapi.core.usecases.category.CreateCategoryCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateCategoryCase createCategoryCase(CategoryGateway gateway) {
        return new CreateCategoryCaseImpl(gateway);
    }

}
