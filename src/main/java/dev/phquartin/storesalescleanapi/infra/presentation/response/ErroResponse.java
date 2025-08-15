package dev.phquartin.storesalescleanapi.infra.presentation.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErroResponse(
        String message,
        String path,
        String timestamp,
        HttpStatus status
) {
}
