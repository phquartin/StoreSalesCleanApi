package dev.phquartin.storesalescleanapi.core.domain;


public record SaleItens(
        Long id,
        Product product,
        int quantity,
        Double price,
        Sale sale
        ) {
}
