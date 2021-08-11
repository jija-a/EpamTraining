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

public class ApplicationLoopMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLoopMenuImpl.class);
    public static final ApplicationMenu APPLICATION_LOOPS_MENU = new ApplicationLoopMenuImpl();

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE)
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE_NUMBERS)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE_SUBSEQUENCE)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE_FUNCTION)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE_DIVIDERS)
                    + "\n5. " + MessageManager.INSTANCE.getMessage(MessageConstant.TASK_CYCLE_PROBLEMS)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_GO_BACK));
            try {
                input = InputReader.readInteger();
                handleUserInput(input);
            } catch (InputMismatchException e) {
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
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.DECREASE_PRINT));
                break;
            case 2:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.SUBSEQUENCE_PRODUCT));
                break;
            case 3:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.CYCLE_FUNCTION));
                break;
            case 4:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.DIVIDERS));
                break;
            case 5:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.PROBLEM));
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
