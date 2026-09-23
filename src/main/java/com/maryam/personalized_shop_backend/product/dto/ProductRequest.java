package com.maryam.personalized_shop_backend.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank
        String name,

        @NotNull
        @Positive(message = "Price must be positive")
        BigDecimal price
) {
}
