package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.ReviewPhoto;

public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, Long> {
}