package ru.floda.ecommerce.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.floda.ecommerce.dto.CartDto;
import ru.floda.ecommerce.dto.CartItemDto;
import ru.floda.ecommerce.service.CartService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {
    private final CartService cartService;

    @GetMapping("/{userId}/cart")
    public ResponseEntity<CartDto> findCart(@PathVariable Long userId) {
        CartDto cartDto = cartService.findCart(userId);
        return ResponseEntity.status(HttpStatus.OK).body(cartDto);
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<CartDto> addItem(@PathVariable Long userId, @RequestBody CartItemDto cartItemDto) {
        CartDto updatedCart = cartService.addToCart(userId, cartItemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedCart);
    }

}
