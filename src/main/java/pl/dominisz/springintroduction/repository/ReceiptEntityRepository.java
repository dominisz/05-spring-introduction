package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.entity.ReceiptEntity;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface ReceiptEntityRepository extends JpaRepository<ReceiptEntity, Long> {
}
