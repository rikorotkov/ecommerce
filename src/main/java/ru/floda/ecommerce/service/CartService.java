package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.CartDto;
import ru.floda.ecommerce.dto.CartItemDto;
import ru.floda.ecommerce.entity.Cart;

public interface CartService {
    Cart getOrCreateCart(Long userId);

    CartDto addToCart(Long userId, CartItemDto cartItemDto);
}
