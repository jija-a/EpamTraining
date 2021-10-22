package task08.service;

public class ServiceException extends Exception {
    /**
     * Exception constructor.
     */
    public ServiceException() {
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     * @param cause   - {@link Throwable} reason of exception
     */
    public ServiceException(final String message,
                        final Throwable cause) {
        super(message, cause);
    }


    /**
     * Exception constructor.
     *
     * @param cause - {@link Throwable} reason of exception
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }
}
