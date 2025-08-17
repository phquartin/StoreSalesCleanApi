package dev.phquartin.storesalescleanapi.infra.presentation.request;

import dev.phquartin.storesalescleanapi.core.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SaleRequest(
        @NotNull(message = "Uma venda precisa de produtos")
        List<SaleItensRequest>itens,
        @NotNull(message = "Forma de pagamento nao pode estar vazia")
        PaymentMethod paymentMethod
) {
}
