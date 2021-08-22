package by.alex.task04.context;

public class InitializingException extends Error {

    public InitializingException() {
    }

    public InitializingException(String message) {
        super(message);
    }

    public InitializingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializingException(Throwable cause) {
        super(cause);
    }

}
