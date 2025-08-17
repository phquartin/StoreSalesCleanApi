package dev.phquartin.storesalescleanapi.infra.presentation;

import dev.phquartin.storesalescleanapi.core.domain.Sale;
import dev.phquartin.storesalescleanapi.core.usecases.sale.CreateSaleCase;
import dev.phquartin.storesalescleanapi.infra.mapper.sale.SaleMapper;
import dev.phquartin.storesalescleanapi.infra.presentation.request.SaleRequest;
import dev.phquartin.storesalescleanapi.infra.presentation.response.SaleResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleMapper mapper;
    private final CreateSaleCase createSaleCase;
    public SaleController(SaleMapper mapper, CreateSaleCase createSaleCase) {
        this.mapper = mapper;
        this.createSaleCase = createSaleCase;
    }

    @PostMapping
    public SaleResponse createSale(@Valid @RequestBody SaleRequest request) {
        Sale execute = createSaleCase.execute(mapper.toDomain(request));
        return mapper.toResponse(execute);
    }

}
