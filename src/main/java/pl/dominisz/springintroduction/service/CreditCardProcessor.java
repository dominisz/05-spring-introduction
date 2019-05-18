package pl.dominisz.springintroduction.service;

import java.math.BigDecimal;

public interface CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount);
}
