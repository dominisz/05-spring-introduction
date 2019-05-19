package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.exception.UserNotFoundException;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.OrderRepository;
import pl.dominisz.springintroduction.repository.UserRepository;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order create(long userId, Order order) {
        boolean userExist = userRepository.existsById(userId);

        if (!userExist) {
            throw new UserNotFoundException(userId);
        }

        return orderRepository.save(order);
    }
}
