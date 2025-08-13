package dev.phquartin.storesalescleanapi.infra.presentation.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(

        @NotBlank(message = "Nome da categoria nao pode estar vazia")
        String name

) {
}
