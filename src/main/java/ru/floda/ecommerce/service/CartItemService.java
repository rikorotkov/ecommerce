package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.CartItemDto;
import ru.floda.ecommerce.entity.CartItem;

public interface CartItemService {
    CartItem convertCartItemDtoToCartItem(CartItemDto cartItemDto);

    CartItemDto convertCartItemToCartItemDto(CartItem cartItem);
}
