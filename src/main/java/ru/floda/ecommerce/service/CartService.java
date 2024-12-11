package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.CartDto;

public interface CartService {
    CartDto getOrCreateCart(Long userId);
}
