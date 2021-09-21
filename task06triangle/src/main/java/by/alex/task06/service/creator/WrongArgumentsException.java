package by.alex.task06.service.creator;

public final class WrongArgumentsException extends RuntimeException {

    /**
     * Class constructor.
     */
    public WrongArgumentsException() {
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     */
    public WrongArgumentsException(final String message) {
        super(message);
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     * @param cause   - exception cause
     */
    public WrongArgumentsException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }

    /**
     * Class constructor.
     *
     * @param cause - exception cause
     */
    public WrongArgumentsException(final Throwable cause) {
        super(cause);
    }
}
