package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAllCategories();

}
