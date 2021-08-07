package com.epam.task02.controller.command;

import com.epam.task02.controller.command.impl.ChangeLocaleCommand;
import com.epam.task02.controller.command.impl.CompareTwoNumbersCommand;

import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> COMMAND_MAP = initCommandMap();

    private static Map<String, Command> initCommandMap() {

        return Map.ofEntries(
                Map.entry("changeLocale", new ChangeLocaleCommand()),
                Map.entry("compareTwoNumbers", new CompareTwoNumbersCommand())
        );
    }

    public Command getCommand(String commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new ChangeLocaleCommand());
    }

}
