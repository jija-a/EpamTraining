package controller.command;

import controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry(CommandName.MATRIX_ATOMIC_FILL, new MatrixAtomicFillCommand()),
                Map.entry(CommandName.MATRIX_LOCK_FILL, new MatrixLockFillCommand()),
                Map.entry(CommandName.MATRIX_SET_FILL, new MatrixSetFillCommand()),
                Map.entry(CommandName.MATRIX_SEMAPHORE_FILL, new MatrixSemaphoreFillCommand()),
                Map.entry(CommandName.NO_SUCH_COMMAND, new NoSuchCommandCommand())
        );
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommandCommand());
    }

}
