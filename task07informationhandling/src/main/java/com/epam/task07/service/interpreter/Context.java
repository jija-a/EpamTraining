package com.epam.task07.service.interpreter;

import java.util.ArrayDeque;

public class Context {
    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }

    @Override
    public String toString() {
        return "Context{"
                + "contextValues=" + contextValues
                + '}';
    }
}
