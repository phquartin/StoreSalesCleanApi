package dev.phquartin.storesalescleanapi.core.domain;

import dev.phquartin.storesalescleanapi.core.enums.MeasureUnit;

public record Product(
        Long code,
        String name,
        Category category,
        Double price,
        Integer stock,
        String imgUrl,
        String description,
        MeasureUnit measureUnit
) {
}
