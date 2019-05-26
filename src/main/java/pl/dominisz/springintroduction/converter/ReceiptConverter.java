package pl.dominisz.springintroduction.converter;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.entity.ReceiptEntity;
import pl.dominisz.springintroduction.model.Receipt;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
@Component
public class ReceiptConverter implements Converter<Receipt, ReceiptEntity> {
    @Override
    public Receipt toModel(ReceiptEntity entity) {
        Receipt receipt = new Receipt();
        receipt.setId(entity.getId());
        receipt.setAmount(entity.getAmount());
        receipt.setMessage(entity.getMessage());
        receipt.setSuccessful(entity.isSuccessful());
        return receipt;
    }

    @Override
    public ReceiptEntity toEntity(Receipt model) {
        ReceiptEntity entity = new ReceiptEntity();
        entity.setAmount(model.getAmount());
        entity.setMessage(model.getMessage());
        entity.setSuccessful(model.isSuccessful());
        return entity;
    }
}
