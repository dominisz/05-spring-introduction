package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class CreditCardBillingServiceTest {

    @Test
    void shouldSuccessfullyChargeCard() {
        Order order = new Order();
        OrderItem hotDog = new OrderItem("Hot dog", new BigDecimal("3.59"));
        OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
                .thenReturn(new ChargeResult(true, "successful"));

        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);

        Assertions.assertTrue(receipt.isSuccessful());
        Assertions.assertEquals(new BigDecimal("8.58"), receipt.getAmount());
    }

    @Test
    void shouldDeclineCharge() {
        Order order = new Order();
        OrderItem hotDog = new OrderItem("Hot dog", new BigDecimal("3.59"));
        OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
        order.addItem(hotDog);
        order.addItem(coffee);

        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
                .thenReturn(new ChargeResult(false, "error"));

        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);

        Assertions.assertFalse(receipt.isSuccessful());
        Assertions.assertEquals("error", receipt.getMessage());
    }

    @Test
    void shouldFailCharge() {
        //TODO zaimplementować
    }
}
