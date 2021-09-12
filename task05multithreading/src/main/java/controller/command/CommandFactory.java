package controller.command;

import controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry(CommandName.MATRIX_COUNTDOWN_FILL, new MatrixCountdownFillCommand()),
                Map.entry(CommandName.MATRIX_LOCK_FILL, new MatrixLockFillCommand()),
                Map.entry(CommandName.MATRIX_PHASER_FILL, new MatrixPhaserFillCommand()),
                Map.entry(CommandName.MATRIX_SEMAPHORE_FILL, new MatrixSemaphoreFillCommand()),
                Map.entry(CommandName.NO_SUCH_COMMAND, new NoSuchCommandCommand())
        );
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommandCommand());
    }

}
