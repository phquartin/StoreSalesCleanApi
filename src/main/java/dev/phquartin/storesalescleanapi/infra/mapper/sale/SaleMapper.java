package dev.phquartin.storesalescleanapi.infra.mapper.sale;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.domain.SaleItens;
import dev.phquartin.storesalescleanapi.infra.mapper.product.ProductMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.SaleItensRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.request.SaleRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.SaleItensResponse;
import dev.phquartin.storesalescleanapi.infra.presentation.response.SaleResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaleMapper {

    private final ProductMapper productMapper;
    public SaleMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Sale toDomain (SaleRequest request){
        Sale sale = new Sale(null, new ArrayList<>(), LocalDateTime.now(), request.paymentMethod());

        List<SaleItensRequest> itens = request.itens();
        List<SaleItens> list = itens.stream()
                .map(
                        saleItensRequest -> new SaleItens(
                                null,
                                productMapper.toDomain(saleItensRequest.product()),
                                saleItensRequest.quantity(),
                                sale
                        ))
                .toList();

        sale.setItens(list);

        return sale;
    }

    public SaleResponse toResponse(Sale sale){
        List<SaleItens> itens = sale.getItens();
        List<SaleItensResponse> saleItensResponses = itens.stream()
                .map(saleItens -> SaleItensResponse.builder()
                        .id(saleItens.getId())
                        .price(saleItens.getPrice())
                        .quantity(saleItens.getQuantity())
                        .product(productMapper.toResponse(saleItens.getProduct()))
                        .build()
                ).toList();

        return SaleResponse.builder()
                .id(sale.getId())
                .total(sale.getTotalValue())
                .dateTime(sale.getDateTime())
                .paymentMethod(sale.getPaymentMethod().toString())
                .saleItens(saleItensResponses)
                .build();

    }

}
