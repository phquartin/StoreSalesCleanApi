package dev.phquartin.storesalescleanapi.core.usecases.sale;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.gateway.SaleGateway;

public class CreateSaleCaseImpl implements CreateSaleCase{

    private final SaleGateway gateway;
    public CreateSaleCaseImpl(SaleGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Sale execute(Sale sale) {
        return gateway.create(sale);
    }
}
