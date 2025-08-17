package dev.phquartin.storesalescleanapi.infra.presentation.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record SaleResponse(Long id, List<SaleItensResponse> saleItens, Double total, LocalDateTime dateTime, String paymentMethod) {
}
