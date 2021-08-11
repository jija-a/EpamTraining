package com.epam.task02.controller.command;

public enum CommandName {
    CHANGE_LOCALE("changeLocale"),
    CHANGE_INPUT_TYPE("changeInputType"),
    COMPARE_TWO_NUMBERS("compareTwoNumbers"),
    NO_SUCH_COMMAND("cycleFunction"),
    POW("pow"),
    REPLACEMENT("replacement"),
    MAX_MIN("maxMin"),
    BRANCHING_FUNCTION("branchingFunction"),
    DECREASE_PRINT("decrease"),
    SUBSEQUENCE_PRODUCT("subsequence"),
    CYCLE_FUNCTION("cycleFunction"),
    DIVIDERS("dividers"),
    PROBLEM("problem");


    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
