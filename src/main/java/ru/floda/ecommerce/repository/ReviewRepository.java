package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}