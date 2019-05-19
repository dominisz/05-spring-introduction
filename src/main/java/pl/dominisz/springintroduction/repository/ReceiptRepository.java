package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.Receipt;

import java.util.Optional;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface ReceiptRepository {

    Optional<Receipt> findById(long id);
}
