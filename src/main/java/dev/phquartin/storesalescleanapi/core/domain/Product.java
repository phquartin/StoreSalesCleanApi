package dev.phquartin.storesalescleanapi.core.domain;

public record Product(
        Long code,
        String name,
        Category category,
        Double price,
        Integer quantity,
        String imgUrl,
        String description
) {
}
