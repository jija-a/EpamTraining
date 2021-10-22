package task08.dao;

/**
 * @see Exception
 */
public class DaoException extends Exception {

    /**
     * Exception constructor.
     */
    public DaoException() {
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     */
    public DaoException(final String message) {
        super(message);
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     * @param cause   - {@link Throwable} reason of exception
     */
    public DaoException(final String message,
                        final Throwable cause) {
        super(message, cause);
    }


    /**
     * Exception constructor.
     *
     * @param cause - {@link Throwable} reason of exception
     */
    public DaoException(final Throwable cause) {
        super(cause);
    }
}
