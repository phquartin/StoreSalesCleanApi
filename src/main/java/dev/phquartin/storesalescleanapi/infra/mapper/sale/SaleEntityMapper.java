package dev.phquartin.storesalescleanapi.infra.mapper.sale;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.domain.SaleItens;
import dev.phquartin.storesalescleanapi.infra.mapper.product.ProductEntityMapper;
import dev.phquartin.storesalescleanapi.infra.persistence.sale.SaleEntity;
import dev.phquartin.storesalescleanapi.infra.persistence.sale.SaleItensEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaleEntityMapper {

    private final ProductEntityMapper productEntityMapper;
    public SaleEntityMapper(ProductEntityMapper productEntityMapper) {
        this.productEntityMapper = productEntityMapper;
    }

    public SaleEntity toEntity(Sale sale) {
        SaleEntity saleEntity = SaleEntity.builder()
                .id(sale.getId())
                .dateTime(sale.getDateTime())
                .paymentMethod(sale.getPaymentMethod())
                .itens(new ArrayList<>())
                .build();

        List<SaleItensEntity> itens = sale.getItens().stream()
                .map(saleItens -> SaleItensEntity.builder()
                        .id(saleItens.getId())
                        .price(saleItens.getPrice())
                        .quantity(saleItens.getQuantity())
                        .sale(saleEntity)
                        .product(productEntityMapper.toEntity(saleItens.getProduct()))
                        .build()
                ).toList();

        saleEntity.setItens(itens);
        return saleEntity;
    }


    public Sale toDomain(SaleEntity saleEntity) {
        Sale sale = new Sale(
                saleEntity.getId(),
                new ArrayList<>(),
                saleEntity.getDateTime(),
                saleEntity.getPaymentMethod()
        );

        List<SaleItens> saleItensList = saleEntity.getItens().stream()
                .map(saleItensEntity -> new SaleItens(
                        saleItensEntity.getId(),
                        productEntityMapper.toDomain(saleItensEntity.getProduct()),
                        saleItensEntity.getQuantity(),
                        sale
                ))
                .toList();

        sale.setItens(saleItensList);
        return sale;
    }


}
