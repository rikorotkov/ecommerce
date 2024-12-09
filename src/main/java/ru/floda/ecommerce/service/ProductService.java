package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> findAllProducts();

    Optional<ProductDto> findProductById(Long id);

    ProductDto createNewProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto product);

    void deleteProductById(Long id);

}
