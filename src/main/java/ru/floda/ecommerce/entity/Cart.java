package ru.floda.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();

    // Дополнительные методы для работы с `cartItems`
    public void addCartItem(CartItem item) {
        cartItems.add(item);
        item.setCart(this);
    }

    public void removeCartItems(CartItem item) {
        cartItems.remove(item);
        item.setCart(null);
    }

}
