package by.alex.task06.controller.impl;

import by.alex.task06.controller.Command;
import by.alex.task06.view.ConsoleWriter;
import by.alex.task06.view.MessageConstant;
import by.alex.task06.view.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchCommandCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSuchCommandCommand.class);

    @Override
    public void execute() {
        LOGGER.trace("Executing no such command command");

        String msg = MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_NO_SUCH_COMMAND);
        ConsoleWriter.writeln(msg);
    }

}

