package by.alex.task03.controller.command.impl;

import by.alex.task03.controller.command.Command;
import by.alex.task03.util.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalSortCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalSortCommand.class);

    @Override
    public void execute() {
        LOGGER.trace("Executing external sort command");

        String msg = "Sort not ready, in progress";
        ConsoleWriter.writeln(msg);
    }

}
