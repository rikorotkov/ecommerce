package ru.floda.ecommerce.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Review}
 */
@Data
public class ReviewDto {
    Long id;

    String text;

    UserDto user;

    ProductDto product;

    Integer rating;

    List<ReviewPhotoDto> photos;

    Instant createdAt;

    Instant updatedAt;

}