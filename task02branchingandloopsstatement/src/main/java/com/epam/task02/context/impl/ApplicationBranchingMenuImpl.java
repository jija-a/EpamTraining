package com.epam.task02.context.impl;

import com.epam.task02.context.ApplicationMenu;
import com.epam.task02.context.util.InputReader;
import com.epam.task02.controller.Controller;
import com.epam.task02.controller.command.CommandName;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

public class ApplicationBranchingMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationBranchingMenuImpl.class);
    public static final ApplicationMenu APPLICATION_BRANCHING_MENU = new ApplicationBranchingMenuImpl();

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING)
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING_COMPARISON)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING_SQUARE)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING_REPLACEMENT)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING_MAX_MIN)
                    + "\n5. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_BRANCHING_FUNCTION)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_GO_BACK));
            try {
                input = InputReader.readInteger();
                handleUserInput(input);
            } catch (InputMismatchException e) {
                LOGGER.trace("input mismatch from user", e);
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.UNKNOWN_COMMAND));
                InputReader.readLine();
            }
        }
    }

    @Override
    public void handleUserInput(int input) {
        LOGGER.info("handling user input");
        switch (input) {
            case 1:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.COMPARE_TWO_NUMBERS));
                break;
            case 2:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.POW));
                break;
            case 3:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.REPLACEMENT));
                break;
            case 4:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.MAX_MIN));
                break;
            case 5:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.BRANCHING_FUNCTION));
                break;
            case 0:
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_GO_BACK) + "...");
                break;
            default:
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.UNKNOWN_COMMAND));
                break;
        }
    }
}
