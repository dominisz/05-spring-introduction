package pl.dominisz.springintroduction.converter;

import pl.dominisz.springintroduction.entity.OrderEntity;
import pl.dominisz.springintroduction.entity.OrderItemEntity;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public class OrderConverter implements Converter<Order, OrderEntity> {

    private final Converter<OrderItem, OrderItemEntity> orderItemConverter;

    public OrderConverter(Converter<OrderItem, OrderItemEntity> orderItemConverter) {
        this.orderItemConverter = orderItemConverter;
    }

    @Override
    public Order toModel(OrderEntity entity) {
        Order order = new Order();

        order.setId(entity.getId());
        order.setUserId(entity.getUser().getId());

        List<OrderItem> orderItems = entity.getItems().stream()
                .map(orderItemEntity -> orderItemConverter.toModel(orderItemEntity))
                .collect(Collectors.toList());
        order.setItems(orderItems);

        return order;
    }

    @Override
    public OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        List<OrderItemEntity> orderItems = order.getItems().stream()
                .map(orderItem -> orderItemConverter.toEntity(orderItem))
                .collect(Collectors.toList());

        orderEntity.setItems(orderItems);

        return orderEntity;
    }
}
