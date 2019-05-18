package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.math.BigDecimal;

public interface CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount);
}
