package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.converter.Converter;
import pl.dominisz.springintroduction.entity.OrderEntity;
import pl.dominisz.springintroduction.entity.UserEntity;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.repository.UserEntityRepository;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final UserEntityRepository userEntityRepository;
    private final Converter<Order, OrderEntity> orderConverter;

    @Autowired
    public OrderServiceImpl(UserEntityRepository userEntityRepository,
                            Converter<Order, OrderEntity> orderConverter) {
        this.userEntityRepository = userEntityRepository;
        this.orderConverter = orderConverter;
    }

    @Override
    public Order create(long userId, Order order) {
        UserEntity user = userEntityRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        OrderEntity orderEntity = orderConverter.toEntity(order);
        user.getOrders().add(orderEntity);
        orderEntity.setUser(user);
        userEntityRepository.save(user);
        return orderConverter.toModel(orderEntity);
    }
}
