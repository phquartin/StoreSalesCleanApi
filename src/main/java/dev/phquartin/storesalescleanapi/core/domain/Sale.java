package dev.phquartin.storesalescleanapi.core.domain;

import dev.phquartin.storesalescleanapi.core.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public record Sale(
        Long id,
        List<SaleItens> itens,
        LocalDateTime dateTime,
        Double totalValue,
        PaymentMethod paymentMethod
) {
}
