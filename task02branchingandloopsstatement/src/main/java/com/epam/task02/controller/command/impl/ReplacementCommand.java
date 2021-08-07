package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;

import java.util.List;

public class ReplacementCommand implements Command {

    private static final int QTY_OF_PARAMETERS = 2;

    @Override
    public ViewResolver execute() {

        ViewResolver resolver = new ViewResolver();

        List<Double> values = resolver.getInput(QTY_OF_PARAMETERS);
        double m = values.get(0);
        double n = values.get(1);

        if (m == n) {
            m = 0;
            n = 0;
        } else {
            if (m > n) {
                n = m;
            } else {
                m = n;
            }
        }

        resolver.setOutput(n + " " + m);
        return resolver;
    }

}
