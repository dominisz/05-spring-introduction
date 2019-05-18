package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderItem;
import pl.dominisz.springintroduction.model.Receipt;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class CreditCardBillingServiceTest {

    @Test
    void shouldSuccessfullyChargeCard() {
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService();

        Order order = new Order();
        OrderItem hotDog = new OrderItem("Hot dog", new BigDecimal("3.59"));
        OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);

        Assertions.assertTrue(receipt.isSuccessful());
        Assertions.assertEquals(new BigDecimal("8.58"), receipt.getAmount());
    }
}
