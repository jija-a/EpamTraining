package com.epam.task02.context.impl;

import com.epam.task02.context.ApplicationMenu;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationLoopMenuImpl implements ApplicationMenu {

    public static final ApplicationMenu APPLICATION_LOOPS_MENU = new ApplicationLoopMenuImpl();
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void printAvailableOptions() {
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

    }

}
