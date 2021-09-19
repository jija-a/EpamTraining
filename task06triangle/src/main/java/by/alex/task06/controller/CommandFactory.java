package by.alex.task06.controller;

import by.alex.task06.controller.impl.NoSuchCommandCommand;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP =
            initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry(CommandName.NO_SUCH_COMMAND,
                        new NoSuchCommandCommand())
        );
    }

    public Command getCommand(final CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName,
                new NoSuchCommandCommand());
    }

}
