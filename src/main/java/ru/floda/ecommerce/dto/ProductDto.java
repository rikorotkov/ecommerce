package ru.floda.ecommerce.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Product}
 */
@Data
public class ProductDto {
    Long id;

    String name;

    String description;

    Double price;

    List<String> imagesUrls;

    Long categoryId;

    Integer stockQuantity;

    Double rating;

}
