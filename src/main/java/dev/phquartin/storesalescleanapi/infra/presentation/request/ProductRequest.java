package dev.phquartin.storesalescleanapi.infra.presentation.request;

import dev.phquartin.storesalescleanapi.core.enums.MeasureUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        @NotBlank(message = "Nome do produto nao pode estar vazio")
        String name,
        @NotNull(message = "Categoria do produto nao pode estar nula")
        CategoryRequest category,
        @NotNull(message = "Preço do produto nao pode estar nulo")
        Double price,
        @NotNull(message = "Quantidade do produto nao pode estar nula")
        Integer stock,
        String imgUrl,
        String description,
        @NotNull(message = "Unidade de medida do produto nao pode estar nula")
        MeasureUnit measureUnit) {
}
