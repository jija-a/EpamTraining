package by.alex.task06.controller.impl;

import by.alex.task06.controller.Command;
import by.alex.task06.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchCommandCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSuchCommandCommand.class);

    @Override
    public void execute() throws ServiceException {
        LOGGER.trace("Executing no such command command");

    }

}

