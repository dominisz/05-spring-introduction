package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        return null;
    }
}
