package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;

import java.util.List;

public class PowCommand implements Command {

    private static final int QTY_OF_PARAMETERS = 3;

    @Override
    public ViewResolver execute() {

        ViewResolver resolver = new ViewResolver();
        StringBuilder output = new StringBuilder();

        List<Double> values = resolver.getInput(QTY_OF_PARAMETERS);

        for (double value : values) {
            if (value > -1) {
                value = value * value;
            } else {
                value = Math.pow(value, 4);
            }
            output.append(value).append(" ");
        }

        resolver.setOutput(String.valueOf(output));

        return resolver;
    }

}
