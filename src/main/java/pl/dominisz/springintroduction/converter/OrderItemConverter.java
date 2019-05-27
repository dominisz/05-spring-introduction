package pl.dominisz.springintroduction.converter;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.entity.OrderItemEntity;
import pl.dominisz.springintroduction.model.OrderItem;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
@Component
public class OrderItemConverter implements Converter<OrderItem, OrderItemEntity> {
    @Override
    public OrderItem toModel(OrderItemEntity entity) {
        OrderItem orderItem = new OrderItem();

        orderItem.setDescription(entity.getDescription());
        orderItem.setPrice(entity.getPrice());
        orderItem.setQuantity(entity.getQuantity());

        return orderItem;
    }

    @Override
    public OrderItemEntity toEntity(OrderItem model) {
        OrderItemEntity entity = new OrderItemEntity();

        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
        entity.setQuantity(model.getQuantity());

        return entity;
    }
}
