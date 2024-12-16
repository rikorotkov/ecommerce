package ru.floda.ecommerce.dto;

import lombok.Data;

/**
 * DTO for {@link ru.floda.ecommerce.entity.OrderItem}
 */
@Data
public class OrderItemDto {
    Long id;

    Long productId;

    Double price;

    Integer quantity;

    Long orderId;
}