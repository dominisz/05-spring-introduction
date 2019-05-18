package pl.dominisz.springintroduction.exception;

/**
 * http://dominisz.pl
 * 18.05.2019
 */
public class UnreachableException extends RuntimeException {
    public UnreachableException(String message) {
        super(message);
    }
}
