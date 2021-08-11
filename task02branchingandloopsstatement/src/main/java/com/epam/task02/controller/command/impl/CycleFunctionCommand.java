package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CycleFunctionCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(CycleFunctionCommand.class);
    private static final int QTY_OF_PARAMETERS = 2;

    @Override
    public String execute() {
        LOGGER.info("executing cycle function command");

        List<Double> values = InputReader.readInput(ApplicationProperties.APPLICATION_PROPERTIES.getInputType(), QTY_OF_PARAMETERS);
        double a = values.get(0);
        double n = values.get(1);

        double product = CalculatorImpl.CALCULATOR.calculateCycleFunction(a, n);

        return String.valueOf(product);
    }

}
