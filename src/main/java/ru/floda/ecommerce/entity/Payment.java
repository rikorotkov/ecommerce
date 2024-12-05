package ru.floda.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "payment")
    private Order order;

    private LocalDateTime paymentDate;

    private Enum<PaymentStatus> paymentStatus;

    private Double amount;

}
