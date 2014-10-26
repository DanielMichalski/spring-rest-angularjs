package pl.dmichalski.rest.service.exception;

/**
 * Author: Daniel
 */
public class AccountDoesNotExistException extends RuntimeException {

    public AccountDoesNotExistException() {
    }

    public AccountDoesNotExistException(String message) {
        super(message);
    }

    public AccountDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDoesNotExistException(Throwable cause) {
        super(cause);
    }
}
