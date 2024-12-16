package ru.floda.ecommerce.service;

import ru.floda.ecommerce.dto.OrderDto;
import ru.floda.ecommerce.entity.*;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();

    OrderDto convertOrderToDto(Order order);

    Order convertOrderDtoToOrder(OrderDto orderDto, User user, Address address, List<OrderItem> orderItems, Payment payment);

}
