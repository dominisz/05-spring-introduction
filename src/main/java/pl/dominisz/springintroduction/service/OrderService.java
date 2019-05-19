package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.Order;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface OrderService {

    Order createOrder(Order order);
}
