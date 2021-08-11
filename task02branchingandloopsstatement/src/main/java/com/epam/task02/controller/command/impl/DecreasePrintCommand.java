package com.epam.task02.controller.command.impl;

import com.epam.task02.controller.command.Command;
import com.epam.task02.service.impl.CalculatorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecreasePrintCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecreasePrintCommand.class);
    private static final int FROM = 1;
    private static final int TO = 5;

    @Override
    public String execute() {
        LOGGER.info("executing decrease print command");

        return String.valueOf(CalculatorImpl.CALCULATOR.getDecreasingRow(FROM, TO));
    }

}
