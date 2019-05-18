package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, BigDecimal amount);
}
