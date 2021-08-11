package com.epam.task02.controller.command.impl;

import com.epam.task02.controller.command.Command;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ProblemCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProblemCommand.class);

    @Override
    public String execute() {
        LOGGER.info("executing problem solving command");

        return Arrays.toString(CalculatorImpl.CALCULATOR.resolveProblem());
    }

}
