package by.alex.task06.controller;

import by.alex.task06.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
