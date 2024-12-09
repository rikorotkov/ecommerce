package ru.floda.ecommerce.dto;

import lombok.Data;

import java.util.List;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Cart}
 */
@Data
public class CartDto {
    Long id;

    Long userId;

    List<CartItemDto> cartItems;

    Double totalCost;
}