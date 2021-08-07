package com.epam.task02.context.impl;

import com.epam.task02.context.ApplicationMenu;
import com.epam.task02.controller.Controller;
import com.epam.task02.controller.command.CommandType;
import com.epam.task02.controller.command.impl.ChangeInputTypeCommand;
import com.epam.task02.controller.command.impl.ChangeLocaleCommand;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationMainMenuImpl implements ApplicationMenu {

    public static final ApplicationMenu APPLICATION_MENU = new ApplicationMainMenuImpl();

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final MessageManager MESSAGE_MANAGER = MessageManager.INSTANCE;

    private ApplicationMainMenuImpl() {
    }

    @Override
    public void printAvailableOptions() {
        int input = -1;
        while (input != 0) {
            System.out.println(MESSAGE_MANAGER.getMessage(MessageConstant.MAIN_MENU)
                    + "\n1. " + MESSAGE_MANAGER.getMessage(MessageConstant.MENU_BRANCHING)
                    + "\n2. " + MESSAGE_MANAGER.getMessage(MessageConstant.MENU_CYCLE)
                    + "\n3. " + MESSAGE_MANAGER.getMessage(MessageConstant.MAIN_CHOICE_FROM_FILE_OR_MENU)
                    + "\n4. " + MESSAGE_MANAGER.getMessage(MessageConstant.LANG_CHOICE)
                    + "\n0. " + MESSAGE_MANAGER.getMessage(MessageConstant.EXIT));
            try {
                input = SCANNER.nextInt();
                handleUserInput(input);
            } catch (InputMismatchException e) {
                System.out.println("Unknown command, please try again: ");
                SCANNER.nextLine();
            }
        }
    }

    @Override
    public void handleUserInput(int input) {
        switch (input) {
            case 1:
                ApplicationBranchingMenuImpl.APPLICATION_BRANCHING_MENU.printAvailableOptions();
                break;
            case 2:
                ApplicationLoopMenuImpl.APPLICATION_LOOPS_MENU.printAvailableOptions();
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandType.CHANGE_INPUT_TYPE);
                break;
            case 4:
                Controller.CONTROLLER.handleRequest(CommandType.CHANGE_LOCALE_COMMAND);
                break;
            case 0:
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.EXIT + "..."));
                System.exit(-1);
                break;
            default:
                break;
        }
    }

}
