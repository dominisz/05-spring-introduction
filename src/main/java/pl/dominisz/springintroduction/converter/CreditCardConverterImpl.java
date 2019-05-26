package pl.dominisz.springintroduction.converter;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.entity.CreditCardEntity;
import pl.dominisz.springintroduction.model.CreditCard;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
@Component
public class CreditCardConverterImpl implements CreditCardConverter {
    @Override
    public CreditCardEntity toEntity(CreditCard creditCard) {
        CreditCardEntity creditCardEntity = new CreditCardEntity();

        creditCardEntity.setFirstName(creditCard.getFirstName());
        creditCardEntity.setLastName(creditCard.getLastName());
        creditCardEntity.setNumber(creditCard.getNumber());
        creditCardEntity.setExpiryDate(creditCard.getExpiryDate());

        return creditCardEntity;
    }

    @Override
    public CreditCard toCreditCard(CreditCardEntity creditCardEntity) {
        CreditCard creditCard = new CreditCard();

        creditCard.setFirstName(creditCardEntity.getFirstName());
        creditCard.setLastName(creditCardEntity.getLastName());
        creditCard.setExpiryDate(creditCardEntity.getExpiryDate());
        creditCard.setNumber(creditCardEntity.getNumber());

        return creditCard;
    }
}
