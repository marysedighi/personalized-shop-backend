package com.maryam.personalized_shop_backend.product;

import com.maryam.personalized_shop_backend.exception.ProductNotFoundException;
import com.maryam.personalized_shop_backend.product.dto.ProductRequest;
import com.maryam.personalized_shop_backend.product.dto.ProductResponse;
import jakarta.validation.Valid;
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

    public ProductResponse createProduct(@Valid ProductRequest request) {
        return new ProductResponse(4L, request.name(), request.price());
    }

    public ProductResponse getProductById(Long id) {
        return getProducts().stream()
                .filter(product -> product.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
