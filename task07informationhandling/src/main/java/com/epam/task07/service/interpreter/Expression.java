package com.epam.task07.service.interpreter;

@FunctionalInterface
public interface Expression {

    /**
     * Method of functional interface.
     * Interprets math operation in {@link Context}
     *
     * @param c - {@link Context} instance
     */
    void interpret(Context c);
}
