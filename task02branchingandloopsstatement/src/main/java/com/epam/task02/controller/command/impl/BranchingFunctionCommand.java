package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranchingFunctionCommand implements Command {

    private static final int QTY_OF_PARAMETERS = 1;
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchingFunctionCommand.class);

    @Override
    public String execute() {
        LOGGER.info("executing branching function command");

        double x = InputReader.readInput(ApplicationProperties.APPLICATION_PROPERTIES.getInputType(), QTY_OF_PARAMETERS).get(0);
        double result = CalculatorImpl.CALCULATOR.calculateBranchingFunction(x);

        return String.valueOf(result);
    }

}
