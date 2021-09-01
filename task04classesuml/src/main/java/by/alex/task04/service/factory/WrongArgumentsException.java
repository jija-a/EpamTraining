package by.alex.task04.service.factory;

public class WrongArgumentsException extends Exception {

    public WrongArgumentsException() {
    }

    public WrongArgumentsException(String message) {
        super(message);
    }

    public WrongArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentsException(Throwable cause) {
        super(cause);
    }

}
