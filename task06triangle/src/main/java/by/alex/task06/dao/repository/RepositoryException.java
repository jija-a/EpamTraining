package by.alex.task06.dao.repository;

public class RepositoryException extends Exception {

    /**
     * Class constructor.
     */
    public RepositoryException() {
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     */
    public RepositoryException(final String message) {
        super(message);
    }

    /**
     * Class constructor.
     *
     * @param message - exception message
     * @param cause   - exception cause
     */
    public RepositoryException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Class constructor.
     *
     * @param cause - exception cause
     */
    public RepositoryException(final Throwable cause) {
        super(cause);
    }
}
