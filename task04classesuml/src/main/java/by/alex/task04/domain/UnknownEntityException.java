package by.alex.task04.domain;

public class UnknownEntityException extends Exception {

    public UnknownEntityException() {
    }

    public UnknownEntityException(String message) {
        super(message);
    }

    public UnknownEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownEntityException(Throwable cause) {
        super(cause);
    }

}
