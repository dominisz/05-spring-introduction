package pl.dominisz.springintroduction.converter;

import pl.dominisz.springintroduction.entity.UserEntity;
import pl.dominisz.springintroduction.model.User;

/**
 * http://dominisz.pl
 * 26.05.2019
 */
public interface UserConverter {

    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
}
