package by.alex.threads.ex14my_philosophers;

public class ResourсeException extends Throwable {
    public ResourсeException() {
        super();
    }

    public ResourсeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourсeException(String message) {
        super(message);
    }

    public ResourсeException(Throwable cause) {
        super(cause);
    }
}
