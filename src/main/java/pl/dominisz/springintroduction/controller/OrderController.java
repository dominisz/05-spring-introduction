package pl.dominisz.springintroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.service.OrderService;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/users/{userId}/orders")
    public Order create(@PathVariable long userId, @RequestBody Order order) {
        return orderService.create(userId, order);
    }
}
