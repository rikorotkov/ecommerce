package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> findAllCategories();

    Optional<CategoryDto> findCategoryById(Long id);

    CategoryDto createNewCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    void deleteCategoryById(Long id);

}
