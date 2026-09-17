package com.maryam.personalized_shop_backend;

import com.maryam.personalized_shop_backend.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    public List<ProductResponse> getProducts() {
        return List.of(
                new ProductResponse(1L, "Jacket", new BigDecimal("78.99")),
                new ProductResponse(2L, "T-Shirt", new BigDecimal("20.00")),
                new ProductResponse(3L, "Jeans", new BigDecimal("30.99"))
        );
    }
}
