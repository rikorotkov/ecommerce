package ru.floda.ecommerce.dto;

import lombok.Data;

import java.time.Instant;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Discount}
 */
@Data
public class DiscountDto {
    Long id;

    String name;

    Double percentage;

    Double amount;

    Instant startDate;

    Instant endDate;

}