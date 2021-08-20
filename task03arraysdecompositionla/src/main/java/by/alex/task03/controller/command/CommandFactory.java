package by.alex.task03.controller.command;

import by.alex.task03.controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {
        return Map.ofEntries(
                Map.entry(CommandName.BUBBLE_SORT, new BubbleSortCommand()),
                Map.entry(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand()),
                Map.entry(CommandName.EXTERNAL_SORT, new ExternalSortCommand()),
                Map.entry(CommandName.INSERTION_SORT, new InsertionSortCommand()),
                Map.entry(CommandName.MERGE_SORT, new MergeSortCommand()),
                Map.entry(CommandName.MULTIPLY_MATRIX, new MultiplyMatrixCommand()),
                Map.entry(CommandName.NO_SUCH_COMMAND, new NoSuchCommand()),
                Map.entry(CommandName.SELECTION_SORT, new SelectionSortCommand()),
                Map.entry(CommandName.SHAKER_SORT, new ShakerSortCommand()),
                Map.entry(CommandName.SHELL_SORT, new ShellSortCommand()),
                Map.entry(CommandName.SUBTRACT_MATRIX, new SubtractMatrixCommand()),
                Map.entry(CommandName.SUM_MATRIX, new SumMatrixCommand()),
                Map.entry(CommandName.TRANSPOSE_MATRIX, new TransposeMatrixCommand())
        );
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommand());
    }

}
