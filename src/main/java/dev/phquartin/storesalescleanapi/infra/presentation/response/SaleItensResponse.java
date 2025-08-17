package dev.phquartin.storesalescleanapi.infra.presentation.response;

import lombok.Builder;

@Builder
public record SaleItensResponse(Long id, ProductResponse product, int quantity, Double price) {
}
