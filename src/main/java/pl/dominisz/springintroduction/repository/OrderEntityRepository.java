package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.entity.OrderEntity;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
