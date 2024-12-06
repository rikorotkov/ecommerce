package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}