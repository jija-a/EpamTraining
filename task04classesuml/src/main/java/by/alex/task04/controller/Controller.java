package by.alex.task04.controller;

import by.alex.task04.controller.command.Command;
import by.alex.task04.controller.command.CommandFactory;
import by.alex.task04.controller.command.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {

    public static final Controller CONTROLLER = new Controller();
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    public void handleRequest(CommandName commandName) {
        LOGGER.debug("Handling request");

        CommandFactory type = new CommandFactory();
        Command command = type.getCommand(commandName);
        command.execute();
    }

}
