package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.CartItemDto;
import ru.floda.ecommerce.entity.CartItem;
import ru.floda.ecommerce.repository.CartItemRepository;
import ru.floda.ecommerce.service.CartItemService;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItem convertCartItemDtoToCartItem(CartItemDto cartItemDto) {
        return null;
        //TODO: convertCartItemDtoToCartItem
    }

    @Override
    public CartItemDto convertCartItemToCartItemDto(CartItem cartItem) {
        return null;
        // TODO: convertCartItemToCartItemDto
    }
}
