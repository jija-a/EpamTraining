package com.epam.task02.controller.command;

import com.epam.task02.controller.command.impl.*;

import java.util.Map;

public class CommandFactory {

    private static final Map<CommandName, Command> COMMAND_MAP = initCommandMap();

    private static Map<CommandName, Command> initCommandMap() {

        return Map.ofEntries(
                Map.entry(CommandName.BRANCHING_FUNCTION, new BranchingFunctionCommand()),
                Map.entry(CommandName.CHANGE_INPUT_TYPE, new ChangeInputTypeCommand()),
                Map.entry(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand()),

                Map.entry(CommandName.COMPARE_TWO_NUMBERS, new CompareTwoNumbersCommand()),
                Map.entry(CommandName.CYCLE_FUNCTION, new CycleFunctionCommand()),
                Map.entry(CommandName.DECREASE_PRINT, new DecreasePrintCommand()),
                Map.entry(CommandName.DIVIDERS, new DividersCommand()),
                Map.entry(CommandName.MAX_MIN, new MaxMinCommand()),

                Map.entry(CommandName.NO_SUCH_COMMAND, new NoSuchCommandCommand()),

                Map.entry(CommandName.POW, new PowCommand()),
                Map.entry(CommandName.PROBLEM, new ProblemCommand()),
                Map.entry(CommandName.REPLACEMENT, new ReplacementCommand()),
                Map.entry(CommandName.SUBSEQUENCE_PRODUCT, new SubsequenceProductCommand())
        );
    }

    public Command getCommand(CommandName commandName) {

        return COMMAND_MAP.getOrDefault(commandName, new NoSuchCommandCommand());
    }

}
