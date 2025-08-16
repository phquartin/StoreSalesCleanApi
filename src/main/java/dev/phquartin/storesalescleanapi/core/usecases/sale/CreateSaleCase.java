package dev.phquartin.storesalescleanapi.core.usecases.sale;

import dev.phquartin.storesalescleanapi.core.domain.Sale;

public interface CreateSaleCase {

    Sale execute(Sale sale);

}
