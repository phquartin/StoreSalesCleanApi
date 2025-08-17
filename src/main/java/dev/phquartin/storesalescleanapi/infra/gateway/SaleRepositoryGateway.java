package dev.phquartin.storesalescleanapi.infra.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.gateway.SaleGateway;
import org.springframework.stereotype.Component;

@Component
public class SaleRepositoryGateway implements SaleGateway {
    @Override
    public Sale create(Sale sale) {
        return null;
    }
}
