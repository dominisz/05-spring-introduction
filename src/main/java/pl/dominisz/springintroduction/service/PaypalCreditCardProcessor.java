package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class PaypalCreditCardProcessor implements CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        return null;
    }
}
