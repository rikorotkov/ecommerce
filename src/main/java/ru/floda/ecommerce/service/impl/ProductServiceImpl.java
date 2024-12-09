package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.ProductDto;
import ru.floda.ecommerce.entity.Category;
import ru.floda.ecommerce.entity.Product;
import ru.floda.ecommerce.entity.ProductImage;
import ru.floda.ecommerce.repository.ProductRepository;
import ru.floda.ecommerce.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(Long id) {
        return null;
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImagesUrls(product.getImages().stream()
                .map(ProductImage::getUrl)
                .toList());
        productDto.setStockQuantity(product.getStockQuantity());
        productDto.setRating(product.getRating());
        return productDto;
    }

    private Product convertToProduct(ProductDto productDto, Category category, List<ProductImage> images) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        product.setImages(images);
        product.setStockQuantity(productDto.getStockQuantity());
        product.setRating(productDto.getRating());
        return product;
    }

}
