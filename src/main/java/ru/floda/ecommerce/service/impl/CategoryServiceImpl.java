package ru.floda.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.CategoryDto;
import ru.floda.ecommerce.entity.Category;
import ru.floda.ecommerce.repository.CategoryRepository;
import ru.floda.ecommerce.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return null;
        // TODO category service impl + mapper
    }
}
