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

    private final CreditCardConverter creditCardConverter;

    public UserConverterImpl(CreditCardConverter creditCardConverter) {
        this.creditCardConverter = creditCardConverter;
    }

    @Override
    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setCreditCard(creditCardConverter.toEntity(user.getCreditCard()));

        return userEntity;
    }

    @Override
    public User toUser(UserEntity userEntity) {
        User user = new User();

        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setCreditCard(creditCardConverter.toCreditCard(userEntity.getCreditCard()));

        return user;
    }
}
