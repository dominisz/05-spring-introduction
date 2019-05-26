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
    public OrderServiceImpl(UserEntityRepository userEntityRepository, Converter<Order, OrderEntity> orderConverter) {
        this.userEntityRepository = userEntityRepository;
        this.orderConverter = orderConverter;
    }

    @Override
    public Order create(long userId, Order order) {
        //znaleźć użytkownika o userId
        UserEntity user = userEntityRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        //zamienić Order na OrderEntity uwzględniając OrderItemEntity
        OrderEntity orderEntity = orderConverter.toEntity(order);
        //dodać Order do User
        user.getOrders().add(orderEntity);
        //zapisać User
        userEntityRepository.save(user);
        //zamienić Order na OrderEntity i zwrócić
        return orderConverter.toModel(orderEntity);
    }
}
