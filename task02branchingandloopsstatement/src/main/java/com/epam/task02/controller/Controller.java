package com.epam.task02.controller;

import com.epam.task02.controller.command.Command;
import com.epam.task02.controller.command.CommandFactory;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static final Controller CONTROLLER = new Controller();

    private Map<String, Object> parameters;

    private Controller() {
        this.parameters = new HashMap<>();
    }

    public void setParameter(String key, Object parameter) {
        parameters.put(key, parameter);
    }

    public void handleRequest(String commandName) {
        CommandFactory type = new CommandFactory();
        Command command = type.getCommand(commandName);
        command.execute(parameters);
    }

}
