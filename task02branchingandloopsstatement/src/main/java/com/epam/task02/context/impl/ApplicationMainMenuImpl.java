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

public class ApplicationMainMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMainMenuImpl.class);
    public static final ApplicationMenu APPLICATION_MENU = new ApplicationMainMenuImpl();

    private ApplicationMainMenuImpl() {
    }

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_MENU)
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_BRANCHING)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_CYCLE)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_CHOICE_FROM_FILE_OR_MENU)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.LANG_CHOICE)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.EXIT));
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
                ApplicationBranchingMenuImpl.APPLICATION_BRANCHING_MENU.printAvailableOptions();
                break;
            case 2:
                ApplicationLoopMenuImpl.APPLICATION_LOOPS_MENU.printAvailableOptions();
                break;
            case 3:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.CHANGE_INPUT_TYPE));
                break;
            case 4:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandName.CHANGE_LOCALE));
                break;
            case 0:
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.EXIT) + "...");
                System.exit(-1);
                break;
            default:
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.UNKNOWN_COMMAND));
                break;
        }
    }

}
