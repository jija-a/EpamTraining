package controller;

import controller.command.Command;
import controller.command.CommandFactory;
import controller.command.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ServiceException;

public class Controller {

    public static final Controller CONTROLLER = new Controller();
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    public void handleRequest(CommandName commandName) {
        LOGGER.debug("Handling request");

        CommandFactory type = new CommandFactory();
        Command command = type.getCommand(commandName);
        try {
            command.execute();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
