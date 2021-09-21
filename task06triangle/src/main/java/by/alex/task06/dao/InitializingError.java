package by.alex.task06.dao;

public class InitializingError extends Error {

    /**
     * Class constructor.
     *
     * @see Error
     */
    public InitializingError() {
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     * @see Error
     */
    public InitializingError(final String message) {
        super(message);
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     * @param cause   - exception reason
     * @see Error
     */
    public InitializingError(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Class constructor.
     *
     * @param cause - exception reason
     * @see Error
     */
    public InitializingError(final Throwable cause) {
        super(cause);
    }
}
