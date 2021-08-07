package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;

import java.util.List;

public class CompareTwoNumbersCommand implements Command {

    private final ViewResolver resolver = new ViewResolver();
    private static final int QTY_OF_PARAMETERS = 2;

    @Override
    public ViewResolver execute() {

        List<Double> values = resolver.getInput(QTY_OF_PARAMETERS);

        if (values.get(0) > values.get(1)) {
            resolver.setOutput("yes");
        } else {
            resolver.setOutput("no");
        }

        return resolver;
    }

}
