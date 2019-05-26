package pl.dominisz.springintroduction.converter;

import pl.dominisz.springintroduction.entity.CreditCardEntity;
import pl.dominisz.springintroduction.model.CreditCard;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface CreditCardConverter {

    CreditCardEntity toEntity(CreditCard creditCard);
    CreditCard toCreditCard(CreditCardEntity creditCardEntity);
}
