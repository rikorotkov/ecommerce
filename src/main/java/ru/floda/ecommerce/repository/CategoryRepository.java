package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}