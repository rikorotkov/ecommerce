package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.repository.CartRepository;
import ru.floda.ecommerce.service.CartService;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;


}
