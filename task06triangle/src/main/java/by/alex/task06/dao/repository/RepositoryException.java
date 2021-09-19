package by.alex.task06.dao.repository;

public class RepositoryException extends Exception {

    public RepositoryException() {
    }

    public RepositoryException(final String message) {
        super(message);
    }

    public RepositoryException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(final Throwable cause) {
        super(cause);
    }
}
