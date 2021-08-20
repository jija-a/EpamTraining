package by.alex.task03.controller.command.impl;

import by.alex.task03.controller.command.Command;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSuchCommand.class);

    @Override
    public void execute() {
        LOGGER.trace("Executing no such command command");

        String msg = MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_NO_SUCH_COMMAND);
        ConsoleWriter.writeln(msg);
    }

}
