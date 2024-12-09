package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProducts();

    ProductDto findProductById(Long id);

    ProductDto createProduct(ProductDto product);

    ProductDto updateProduct(Long id, ProductDto product);

    void deleteProductById(Long id);

}
