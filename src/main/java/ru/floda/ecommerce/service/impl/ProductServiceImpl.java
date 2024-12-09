package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.ProductDto;
import ru.floda.ecommerce.entity.Category;
import ru.floda.ecommerce.entity.Product;
import ru.floda.ecommerce.entity.ProductImage;
import ru.floda.ecommerce.exception.ResourceNotFoundException;
import ru.floda.ecommerce.repository.CategoryRepository;
import ru.floda.ecommerce.repository.ProductRepository;
import ru.floda.ecommerce.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public ProductDto createNewProduct(ProductDto productDto) {
        // Найти категорию
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Категория с id: " + productDto.getCategoryId() + " не найдена"));

        // Создать список изображений
        List<ProductImage> images = productDto.getImagesUrls().stream()
                .map(url -> ProductImage.builder()
                        .url(url)
                        .build())
                .collect(Collectors.toList());

        // Создать сущность продукта
        Product product = convertToEntity(productDto, category, images);

        // Установить обратную связь для изображений
        images.forEach(image -> image.setProduct(product));

        // Сохранить продукт в репозитории
        return convertToDto(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Товар с id: " + id + " не найден"));
        Category category = null;

        if (productDto.getCategoryId() != null) {
            category = categoryRepository.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Категория с id: " + productDto.getCategoryId() + " не найдена"));
        }
        if (productDto.getName() != null) {
            product.setName(productDto.getName());
        }
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getStockQuantity() != null) {
            product.setStockQuantity(productDto.getStockQuantity());
        }
        if (productDto.getRating() != null) {
            product.setRating(productDto.getRating());
        }
        if (category != null) {
            product.setCategory(category);
        }

        if (productDto.getImagesUrls() != null && !productDto.getImagesUrls().isEmpty()) {
            List<ProductImage> updatedImages = productDto.getImagesUrls().stream()
                    .map(url -> ProductImage.builder().url(url).product(product).build())
                    .collect(Collectors.toList());
            product.setImages(updatedImages);
        }

        return convertToDto(productRepository.save(product));

    }

    @Override
    public void deleteProductById(Long id) {
        categoryRepository.deleteById(id);
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = new ProductDto();
        Category category = product.getCategory();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImagesUrls(product.getImages().stream()
                .map(ProductImage::getUrl)
                .toList());
        productDto.setCategoryId(category.getId());
        productDto.setStockQuantity(product.getStockQuantity());
        productDto.setRating(product.getRating());
        return productDto;
    }

    private Product convertToEntity(ProductDto productDto, Category category, List<ProductImage> images) {
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
