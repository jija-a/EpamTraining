package by.alex.task03.controller;

import by.alex.task03.controller.command.Command;
import by.alex.task03.controller.command.CommandFactory;
import by.alex.task03.controller.command.CommandName;
import by.alex.task03.service.ServiceException;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
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
            LOGGER.error("Service exception: ", e);
            ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_WRONG_ARGUMENTS));
        }

    }

}
