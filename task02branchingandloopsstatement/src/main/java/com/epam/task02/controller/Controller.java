package com.epam.task02.controller;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;
import com.epam.task02.controller.command.CommandFactory;

public class Controller {

    public static final Controller CONTROLLER = new Controller();

    public String handleRequest(String commandName) {
        CommandFactory type = new CommandFactory();
        Command command = type.getCommand(commandName);
        ViewResolver resolver = command.execute();

        if (null == resolver) {
            resolver = new ViewResolver();
        }

        if (null == resolver.getOutput()) {
            resolver.setOutput("Can't get result, try again later");
        }

        return resolver.getOutput();
    }

}
