package pl.dominisz.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.dominisz.springintroduction.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Repository
public class ListUserRepository implements UserRepository {

    private List<User> users = new ArrayList<>();
    private long lastId = 0;

    @Override
    public User save(User user) {
        lastId++;
        user.setId(lastId);
        users.add(user);

        return user;
    }

    @Override
    public boolean existsById(long userId) {
        return users.stream()
                .anyMatch(user -> user.getId() == userId);
    }

}
