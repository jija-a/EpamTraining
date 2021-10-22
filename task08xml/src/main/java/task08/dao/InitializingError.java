package task08.dao;

/**
 * @see Error
 */
public class InitializingError extends Error {

    /**
     * Error constructor.
     */
    public InitializingError() {
    }

    /**
     * Error constructor.
     *
     * @param message - message that explains why error appears
     */
    public InitializingError(final String message) {
        super(message);
    }

    /**
     * Error constructor.
     *
     * @param message - message that explains why error appears
     * @param cause   - {@link Throwable} reason of error
     */
    public InitializingError(final String message,
                             final Throwable cause) {
        super(message, cause);
    }

    /**
     * Error constructor.
     *
     * @param cause - {@link Throwable} reason of error
     */
    public InitializingError(final Throwable cause) {
        super(cause);
    }
}
