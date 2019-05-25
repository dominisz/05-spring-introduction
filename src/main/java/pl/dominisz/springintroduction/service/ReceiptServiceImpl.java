package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.dto.CreateReceiptDto;
import pl.dominisz.springintroduction.model.Receipt;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public Optional<Receipt> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Receipt create(CreateReceiptDto createReceiptDto) {
        //znaleźć użytkownika o userId
        //znaleźć zamówienie o orderId
        //wywołać chargeOrder
        //zapisać utworzony Receipt
        return null;
    }
}
