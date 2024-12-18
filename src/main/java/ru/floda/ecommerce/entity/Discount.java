package ru.floda.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // Новогодняя распродажа etc ...

    private Double percentage;
    // Процент скидки 10.0

    private Double amount;
    // Фиксированный размер скидки

    private Instant startDate;

    private Instant endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
