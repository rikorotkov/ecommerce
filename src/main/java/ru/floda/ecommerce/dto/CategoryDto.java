package ru.floda.ecommerce.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Category}
 */
@Data
@Value
public class CategoryDto implements Serializable {
    Long id;

    String name;

    String description;

}