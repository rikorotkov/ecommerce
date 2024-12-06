package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}