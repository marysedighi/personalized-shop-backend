package com.maryam.personalized_shop_backend.product;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.maryam.personalized_shop_backend.exception.ProductNotFoundException;
import com.maryam.personalized_shop_backend.product.dto.ProductRequest;
import com.maryam.personalized_shop_backend.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // spring injects the repository through the constructor injection
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        return productRepository.findAll()// select * from products
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice()
                ))
                .toList();
    }

    public ProductResponse createProduct(ProductRequest request) {

        Product savedProduct = productRepository.save(new Product(request.name(), request.price()));

        return new ProductResponse(savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public ProductResponse updateProductById(Long id, ProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.update(request.name(), request.price());

        Product updatedProduct = productRepository.save(product);

        return new ProductResponse(
                updatedProduct.getId(),
                updatedProduct.getName(),
                updatedProduct.getPrice()
        );
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }
}
