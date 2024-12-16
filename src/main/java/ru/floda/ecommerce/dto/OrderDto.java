package ru.floda.ecommerce.dto;

import lombok.Data;
import ru.floda.ecommerce.entity.OrderStatus;

import java.util.List;

/**
 * DTO for {@link ru.floda.ecommerce.entity.Order}
 */
@Data
public class OrderDto {
    Long id;

    Long userId;

    OrderStatus orderStatus;

    Long addressId;

    List<Long> orderItems;

    Long paymentId;
}