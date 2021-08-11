package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubsequenceProductCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubsequenceProductCommand.class);
    private static final int QTY_OF_PARAMETERS = 1;

    @Override
    public String execute() {
        LOGGER.info("executing subsequence product command");

        double a = InputReader.readInput(ApplicationProperties.APPLICATION_PROPERTIES.getInputType(), QTY_OF_PARAMETERS).get(0);
        double product = CalculatorImpl.CALCULATOR.findSubsequenceProduct(a);

        return String.valueOf(product);
    }

}
