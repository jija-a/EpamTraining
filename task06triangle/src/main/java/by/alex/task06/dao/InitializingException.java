package by.alex.task06.dao;

public class InitializingException extends Error {

    public InitializingException() {
    }

    public InitializingException(final String message) {
        super(message);
    }

    public InitializingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InitializingException(final Throwable cause) {
        super(cause);
    }
}
