package pl.dominisz.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.dominisz.springintroduction.model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * http://dominisz.pl
 * 25.05.2019
 */
@Repository
public class ListReceiptRepository implements ReceiptRepository {

    private final List<Receipt> receipts = new ArrayList<>();
    private long lastId = 0;

    @Override
    public Optional<Receipt> findById(long id) {
        return receipts.stream()
                .filter(receipt -> receipt.getId() == id)
                .findFirst();
    }

    @Override
    public Receipt save(Receipt receipt) {
        lastId++;
        receipt.setId(lastId);
        receipts.add(receipt);
        return receipt;
    }
}
