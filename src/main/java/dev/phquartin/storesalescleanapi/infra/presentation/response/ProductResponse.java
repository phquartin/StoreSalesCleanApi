package dev.phquartin.storesalescleanapi.infra.presentation.response;

import dev.phquartin.storesalescleanapi.core.domain.Category;
import dev.phquartin.storesalescleanapi.core.enums.MeasureUnit;
import lombok.Builder;

@Builder
public record ProductResponse(Long code,
                              String name,
                              Category category,
                              Double price,
                              Integer stock,
                              String imgUrl,
                              String description,
                              MeasureUnit measureUnit) {
}
