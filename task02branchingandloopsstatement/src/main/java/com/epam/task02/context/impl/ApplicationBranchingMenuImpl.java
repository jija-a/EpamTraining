package com.epam.task02.context.impl;

import com.epam.task02.context.ApplicationMenu;
import com.epam.task02.controller.Controller;
import com.epam.task02.controller.command.CommandType;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationBranchingMenuImpl implements ApplicationMenu {

    public static final ApplicationMenu APPLICATION_BRANCHING_MENU = new ApplicationBranchingMenuImpl();
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void printAvailableOptions() {
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
                input = SCANNER.nextInt();
                handleUserInput(input);
            } catch (InputMismatchException e) {
                System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.UNKNOWN_COMMAND));
                SCANNER.nextLine();
            }
        }
    }

    @Override
    public void handleUserInput(int input) {
        switch (input) {
            case 1:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandType.COMPARE_TWO_NUMBERS));
                break;
            case 2:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandType.POW_COMMAND));
                break;
            case 3:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandType.REPLACEMENT_COMMAND));
                break;
            case 4:
                System.out.println(Controller.CONTROLLER.handleRequest(CommandType.MAX_MIN_COMMAND));
                break;
            case 5:

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
