package dev.phquartin.storesalescleanapi.infra.presentation.request;

public record SaleItensRequest(
        ProductRequest product,
        int quantity
) {
}
