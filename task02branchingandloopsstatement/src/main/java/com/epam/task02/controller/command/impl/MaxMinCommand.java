package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MaxMinCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaxMinCommand.class);
    private static final int QTY_OF_PARAMETERS = 4;

    @Override
    public String execute() {
        LOGGER.info("executing max min command");
        List<Double> values = InputReader.readInput(ApplicationProperties.APPLICATION_PROPERTIES.getInputType(), QTY_OF_PARAMETERS);

        double a = values.get(0);
        double b = values.get(1);
        double c = values.get(2);
        double d = values.get(3);

        double minAB;
        double minCD;
        double max;

        minAB = CalculatorImpl.CALCULATOR.findMin(a, b);
        minCD = CalculatorImpl.CALCULATOR.findMin(c, d);
        max = CalculatorImpl.CALCULATOR.findMax(minAB, minCD);

        return String.valueOf(max);
    }

}
