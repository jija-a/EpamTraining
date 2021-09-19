package by.alex.task06.service.creator;

public final class WrongArgumentsException extends RuntimeException {

    public WrongArgumentsException() {
    }

    public WrongArgumentsException(final String message) {
        super(message);
    }

    public WrongArgumentsException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentsException(final Throwable cause) {
        super(cause);
    }

}
