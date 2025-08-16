package dev.phquartin.storesalescleanapi.core.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Sale;

public interface SaleGateway {

    Sale create(Sale sale);

}
