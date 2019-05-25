package pl.dominisz.springintroduction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * http://dominisz.pl
 * 19.05.2019
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long orderId) {
        super("Order with id " + orderId + " not found");
    }
}
