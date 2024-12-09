package ru.floda.ecommerce.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link ru.floda.ecommerce.entity.CartItem}
 */
@Data
public class CartItemDto {
    Long id;

    Long productId;

    String productName;

    Integer quantity;

    Double price;

    Double totalPrice;
}