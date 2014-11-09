package pl.dmichalski.core.services.exceptions;

/**
 * Author: Daniel
 */
public class AccountExistsException extends RuntimeException {

    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException() {
        super();
    }

}
