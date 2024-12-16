package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.*;

import java.util.List;

public interface AdminService {
    List<UserDto> findAllUsers();

    List<OrderDto> findAllOrders();

    List<ReviewDto> findAllReviews();

    List<ProductDto> findProductsByCategory(CategoryDto category);

    void deleteProductById(Long id);

    void deleteCategoryById(Long id);

    void deleteReviewById(Long id);
}
