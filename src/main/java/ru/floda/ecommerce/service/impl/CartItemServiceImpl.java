package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.repository.CartItemRepository;
import ru.floda.ecommerce.service.CartItemService;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;


}
