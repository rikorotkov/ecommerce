package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}