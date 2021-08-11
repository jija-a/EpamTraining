package com.epam.task02.controller;

import com.epam.task02.controller.command.Command;
import com.epam.task02.controller.command.CommandFactory;
import com.epam.task02.controller.command.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {

    public static final Controller CONTROLLER = new Controller();
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    public String handleRequest(CommandName commandName) {
        LOGGER.debug("Handling request");

        CommandFactory type = null;

        try {
            type = new CommandFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Command command = type.getCommand(commandName);

        return command.execute();
    }

}
