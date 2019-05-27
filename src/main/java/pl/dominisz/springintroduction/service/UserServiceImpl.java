package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dominisz.springintroduction.converter.Converter;
import pl.dominisz.springintroduction.entity.UserEntity;
import pl.dominisz.springintroduction.model.User;
import pl.dominisz.springintroduction.repository.UserEntityRepository;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final Converter<User, UserEntity> userConverter;

    @Autowired
    public UserServiceImpl(UserEntityRepository userEntityRepository,
                           Converter<User, UserEntity> userConverter) {
        this.userEntityRepository = userEntityRepository;
        this.userConverter = userConverter;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = userConverter.toEntity(user);

        userEntity = userEntityRepository.save(userEntity);

        return userConverter.toModel(userEntity);
    }
}
