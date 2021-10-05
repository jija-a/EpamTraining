package com.epam.task07.service.interpreter;

/**
 * @see Exception
 */
public class InterpreterException extends Exception {

    /**
     * Exception constructor.
     */
    public InterpreterException() {
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     */
    public InterpreterException(final String message) {
        super(message);
    }

    /**
     * Exception constructor.
     *
     * @param message - message that explains why exception appears
     * @param cause   - {@link Throwable} reason of exception
     */
    public InterpreterException(final String message,
                        final Throwable cause) {
        super(message, cause);
    }


    /**
     * Exception constructor.
     *
     * @param cause - {@link Throwable} reason of exception
     */
    public InterpreterException(final Throwable cause) {
        super(cause);
    }
}
