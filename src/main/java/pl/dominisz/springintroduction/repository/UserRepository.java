package pl.dominisz.springintroduction.repository;

import pl.dominisz.springintroduction.model.User;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
public interface UserRepository {

    User save(User user);

    boolean existsById(long userId);
}
