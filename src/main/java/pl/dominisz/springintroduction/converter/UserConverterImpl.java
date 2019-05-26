package pl.dominisz.springintroduction.converter;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.entity.UserEntity;
import pl.dominisz.springintroduction.model.User;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserEntity toEntity(User user) {
        return null;
    }

    @Override
    public User toUser(UserEntity userEntity) {
        return null;
    }
}
