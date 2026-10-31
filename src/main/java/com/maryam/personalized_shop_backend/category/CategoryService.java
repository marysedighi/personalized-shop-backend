package com.maryam.personalized_shop_backend.category;

import com.maryam.personalized_shop_backend.category.dto.CategoryRequest;
import com.maryam.personalized_shop_backend.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryRequest request) {

        Category savedCategory = categoryRepository.save(new Category(request.name()));

        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

}
