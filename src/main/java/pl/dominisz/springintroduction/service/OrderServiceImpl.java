package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    public OrderServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Order create(long userId, Order order) {
        //znaleźć użytkownika o userId
        //zamienić Order na OrderEntity uwzględniając OrderItemEntity
        //dodać Order do User
        //zapisać User
        //zamienić Order na OrderEntity i zwrócić
        return null;
    }
}
