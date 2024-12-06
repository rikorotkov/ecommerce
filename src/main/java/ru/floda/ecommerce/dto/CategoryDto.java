package ru.floda.ecommerce.dto;

import lombok.Data;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Category}
 */
@Data
public class CategoryDto {
    Long id;

    String name;

    String description;

}