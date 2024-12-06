package ru.floda.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.floda.ecommerce.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}