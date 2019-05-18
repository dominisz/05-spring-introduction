package pl.dominisz.springintroduction.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class OrderTest {

    @Test
    public void newOrderShouldBeEmpty() {
        Order order = new Order();

        Assertions.assertTrue(order.getItems().isEmpty());
        Assertions.assertEquals(BigDecimal.ZERO, order.getAmount());
    }

    @Test
    public void orderShouldContainTwoOrderItems() {
        Order order = new Order();
        OrderItem hotDog = new OrderItem("Hot dog", new BigDecimal("3.59"));
        OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
        order.addItem(hotDog);
        order.addItem(coffee);

        Assertions.assertEquals(2, order.getItems().size());
        Assertions.assertEquals(new BigDecimal("8.58"), order.getAmount());
    }
}
