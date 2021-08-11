package com.epam.task02.controller.command.impl;

import com.epam.task02.context.util.InputType;
import com.epam.task02.controller.command.Command;
import com.epam.task02.domain.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeInputTypeCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeInputTypeCommand.class);

    @Override
    public String execute() {
        LOGGER.info("executing command changing input type");
        if (ApplicationProperties.APPLICATION_PROPERTIES.getInputType().equals(InputType.CONSOLE)) {
            ApplicationProperties.APPLICATION_PROPERTIES.setInputType(InputType.FILE);
        } else {
            ApplicationProperties.APPLICATION_PROPERTIES.setInputType(InputType.CONSOLE);
        }

        return "Input type changed";
    }

}
