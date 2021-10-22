package by.alex.task08.controller.command;

import by.alex.task08.controller.command.impl.ParseCommand;
import by.alex.task08.controller.command.impl.ToHomePageCommand;
import by.alex.task08.controller.command.impl.UploadCommand;

import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> COMMAND_MAP = initCommandMap();

    private static Map<String, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry("to_home_page", new ToHomePageCommand()),
                Map.entry("upload",new UploadCommand()),
                Map.entry("parse", new ParseCommand())
        );
    }

    public Command getCommand(String commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new ToHomePageCommand());
    }

}
