package by.alex.task06.service;

public final class ServiceException extends Exception {

    /**
     * Class constructor.
     */
    public ServiceException() {
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     * @param cause   - exception cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Class constructor.
     *
     * @param cause - exception cause
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }
}
