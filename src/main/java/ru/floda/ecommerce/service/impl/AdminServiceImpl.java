package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.*;
import ru.floda.ecommerce.repository.CategoryRepository;
import ru.floda.ecommerce.repository.ProductRepository;
import ru.floda.ecommerce.repository.ReviewRepository;
import ru.floda.ecommerce.repository.UserRepository;
import ru.floda.ecommerce.service.AdminService;
import ru.floda.ecommerce.service.CategoryService;
import ru.floda.ecommerce.service.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final CategoryService categoryService;
    private final ProductService productService;


    @Override
    public List<UserDto> findAllUsers() {
        return List.of();
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return List.of();
    }

    @Override
    public List<ReviewDto> findAllReviews() {
        return List.of();
    }

    @Override
    public List<ProductDto> findProductsByCategory(CategoryDto category) {
        return List.of();
    }

    @Override
    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }

    @Override
    public void deleteCategoryById(Long id) {

    }

    @Override
    public void deleteReviewById(Long id) {

    }
}
