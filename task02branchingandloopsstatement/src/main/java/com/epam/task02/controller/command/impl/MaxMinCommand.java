package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;

import java.util.List;

public class MaxMinCommand implements Command {

    private static final int QTY_OF_PARAMETERS = 4;

    @Override
    public ViewResolver execute() {

        ViewResolver resolver = new ViewResolver();

        List<Double> values = resolver.getInput(QTY_OF_PARAMETERS);

        double a = Math.min(values.get(0), values.get(1));
        double b = Math.min(values.get(2), values.get(3));

        String output = String.valueOf(Math.max(a, b));
        resolver.setOutput(output);

        return resolver;
    }

}
