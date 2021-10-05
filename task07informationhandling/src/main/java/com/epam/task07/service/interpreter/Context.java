package com.epam.task07.service.interpreter;

import java.util.ArrayDeque;

public class Context {

    /**
     * Number values.
     */
    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    /**
     * Value getter.
     *
     * @return {@link Integer} value
     */
    public Integer popValue() {
        return contextValues.pop();
    }

    /**
     * Value setter.
     *
     * @param value - {@link Integer} value
     */
    public void pushValue(final Integer value) {
        this.contextValues.push(value);
    }

    /**
     * @see Object
     */
    @Override
    public String toString() {
        return "Context{"
                + "contextValues=" + contextValues
                + '}';
    }
}
