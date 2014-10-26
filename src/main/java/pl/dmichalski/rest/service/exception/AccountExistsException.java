package pl.dmichalski.rest.service.exception;

/**
 * Author: Daniel
 */
public class AccountExistsException extends RuntimeException {

    public AccountExistsException() {
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistsException(Throwable cause) {
        super(cause);
    }
}
