package pl.dominisz.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dominisz.springintroduction.entity.UserEntity;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
