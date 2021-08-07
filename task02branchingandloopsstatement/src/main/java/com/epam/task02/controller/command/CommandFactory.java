package com.epam.task02.controller.command;

import com.epam.task02.controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> COMMAND_MAP = initCommandMap();

    private static Map<String, Command> initCommandMap() {

        return Map.ofEntries(
                Map.entry(CommandType.CHANGE_INPUT_TYPE, new ChangeInputTypeCommand()),
                Map.entry(CommandType.CHANGE_LOCALE_COMMAND, new ChangeLocaleCommand()),
                Map.entry(CommandType.COMPARE_TWO_NUMBERS, new CompareTwoNumbersCommand()),
                Map.entry(CommandType.NO_SUCH_COMMAND, new NoSuchCommandCommand()),
                Map.entry(CommandType.POW_COMMAND, new PowCommand()),
                Map.entry(CommandType.READ_FROM_FILE, new ReadFromFileCommand()),
                Map.entry(CommandType.REPLACEMENT_COMMAND, new ReplacementCommand())
        );
    }

    public Command getCommand(String commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommandCommand());
    }

}
