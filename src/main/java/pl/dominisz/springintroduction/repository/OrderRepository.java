package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.Order;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface OrderRepository {

    Order save(Order order);
}
