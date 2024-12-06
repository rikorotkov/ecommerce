package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}