package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.Order;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(long orderId);
}
