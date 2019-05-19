package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.Receipt;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface ReceiptService {

    Optional<Receipt> findById(long id);
}
