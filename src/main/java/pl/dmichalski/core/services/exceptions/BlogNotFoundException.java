package pl.dmichalski.core.services.exceptions;

/**
 * Author: Daniel
 */
public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException() {
    }

}
