package controller.command.impl;

import controller.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.ConsoleWriter;

public class NoSuchCommandCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSuchCommandCommand.class);

    @Override
    public void execute() {
        LOGGER.trace("Executing no such command command");

        ConsoleWriter.writeln("No such command");
    }

}

