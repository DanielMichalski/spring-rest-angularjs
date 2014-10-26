package pl.dmichalski.rest.service.exception;

/**
 * Author: Daniel
 */
public class BlogExistsException extends RuntimeException {

    public BlogExistsException() {
    }

    public BlogExistsException(String message) {
        super(message);
    }

    public BlogExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogExistsException(Throwable cause) {
        super(cause);
    }
}
