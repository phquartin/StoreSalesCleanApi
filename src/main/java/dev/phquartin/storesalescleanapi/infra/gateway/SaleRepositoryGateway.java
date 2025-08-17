package dev.phquartin.storesalescleanapi.infra.gateway;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.domain.SaleItens;
import dev.phquartin.storesalescleanapi.core.gateway.SaleGateway;
import dev.phquartin.storesalescleanapi.infra.mapper.sale.SaleEntityMapper;
import dev.phquartin.storesalescleanapi.infra.persistence.sale.SaleEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.sale.SaleItensRepository;
import dev.phquartin.storesalescleanapi.infra.persistence.sale.SaleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleRepositoryGateway implements SaleGateway {

    private final SaleRepository saleRepository;
    private final SaleItensRepository saleItensRepository;
    private final SaleEntityMapper mapper;
    public SaleRepositoryGateway(SaleRepository saleRepository, SaleItensRepository saleItensRepository, SaleEntityMapper mapper) {
        this.saleRepository = saleRepository;
        this.saleItensRepository = saleItensRepository;
        this.mapper = mapper;
    }

    @Override
    public Sale create(Sale sale) {
        return mapper.toDomain(saleRepository.save(mapper.toEntity(sale)));
    }
}
