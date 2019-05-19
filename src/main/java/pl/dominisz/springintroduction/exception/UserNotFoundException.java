package pl.dominisz.springintroduction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long userId) {
        super("User with " + userId + " not found");
    }
}
