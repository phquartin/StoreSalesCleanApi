package dev.phquartin.storesalescleanapi.core.domain;

public record Product(
        Long code,
        String name,
        Category category,
        Double price,
        Integer stock,
        String imgUrl,
        String description
) {
}
