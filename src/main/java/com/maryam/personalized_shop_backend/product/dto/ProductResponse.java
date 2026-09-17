package com.maryam.personalized_shop_backend.product.dto;

import java.math.BigDecimal;

public record ProductResponse (
        Long id,
        String name,
        BigDecimal price
) {
}
