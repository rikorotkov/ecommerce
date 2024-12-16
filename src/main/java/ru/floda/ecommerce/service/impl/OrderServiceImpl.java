package ru.floda.ecommerce.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.floda.ecommerce.dto.OrderDto;
import ru.floda.ecommerce.entity.*;
import ru.floda.ecommerce.repository.OrderRepository;
import ru.floda.ecommerce.service.OrderService;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::convertOrderToDto).toList();
    }

    @Override
    public OrderDto convertOrderToDto(Order order) {
        OrderDto dto = new OrderDto();
        Address address = order.getAddress();

        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setAddressId(address.getId());
        dto.setOrderItems(order.getOrderItems().stream()
                .map(OrderItem::getId)
                .toList());
        dto.setPaymentId(order.getPayment().getId());
        return dto;
    }

    @Override
    public Order convertOrderDtoToOrder(OrderDto dto, User user, Address address, List<OrderItem> orderItems, Payment payment) {
        Order order = new Order();

        order.setId(dto.getId());
        order.setUser(user);
        order.setOrderStatus(dto.getOrderStatus());
        order.setAddress(address);
        order.setOrderItems(orderItems);
        order.setPayment(payment);

        return order;
    }
}
