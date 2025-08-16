package dev.phquartin.storesalescleanapi.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Sale(
        Long id,
        List<SaleItens> itens,
        LocalDateTime dateTime,
        Double totalValue
) {
}
