package by.alex.task03.controller.command;

import java.util.Map;

public class CommandFactory {
    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return null;
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, null);
    }

}
