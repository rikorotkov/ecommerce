package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}