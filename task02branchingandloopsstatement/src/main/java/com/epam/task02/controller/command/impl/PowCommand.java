package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PowCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(PowCommand.class);
    private static final int QTY_OF_PARAMETERS = 3;

    @Override
    public String execute() {
        LOGGER.info("executing pow command");
        List<Double> values = InputReader.readInput(ApplicationProperties.APPLICATION_PROPERTIES.getInputType(), QTY_OF_PARAMETERS);

        return String.valueOf(CalculatorImpl.CALCULATOR.powValues(values));
    }

}
