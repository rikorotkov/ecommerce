package ru.floda.ecommerce.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.CartDto;
import ru.floda.ecommerce.dto.CartItemDto;
import ru.floda.ecommerce.entity.Cart;
import ru.floda.ecommerce.entity.CartItem;
import ru.floda.ecommerce.entity.Product;
import ru.floda.ecommerce.entity.User;
import ru.floda.ecommerce.exception.ResourceNotFoundException;
import ru.floda.ecommerce.repository.CartRepository;
import ru.floda.ecommerce.repository.UserRepository;
import ru.floda.ecommerce.service.CartService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public CartDto getOrCreateCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> createCartForUser(userId));

        return convertCartToDto(cart);
    }

    private Cart createCartForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Пользователь с id: " + userId + " не найден"));

        Cart cart = Cart.builder()
                .user(user)
                .cartItems(new ArrayList<>())
                .build();

        return cartRepository.save(cart);
    }

    private CartDto convertCartToDto(Cart cart) {
        CartDto dto = new CartDto();
        User user = cart.getUser();

        List<CartItemDto> cartItemDto = cart.getCartItems()
                .stream()
                .map(this::convertCartItemToDto)
                .toList();

        dto.setId(cart.getId());
        dto.setUserId(user.getId());
        dto.setCartItems(cartItemDto);

        double totalCost = cartItemDto.stream()
                .mapToDouble(CartItemDto::getTotalPrice)
                .sum();

        dto.setTotalCost(totalCost);

        return dto;
    }

    private Cart convertCartDtoToEntity(CartDto dto, User user, List<CartItem> items) {
        Cart cart = new Cart();

        cart.setId(dto.getId());
        cart.setUser(user);
        cart.setCartItems(items);

        return cart;
    }

    private CartItemDto convertCartItemToDto(CartItem cartItem) {
        if (cartItem == null) {
            throw new IllegalStateException("Товары в рорзине отсутствуют");
        }

        CartItemDto dto = new CartItemDto();
        Product product = cartItem.getProduct();

        dto.setId(cartItem.getId());
        dto.setProductId(product.getId());
        dto.setProductName(product.getName());
        dto.setQuantity(cartItem.getQuantity());
        dto.setPrice(product.getPrice());
        dto.setTotalPrice(product.getPrice() * cartItem.getQuantity());

        return dto;
    }

}