package by.alex.task04.view.impl;

import by.alex.task04.context.impl.ApplicationContextImpl;
import by.alex.task04.controller.Controller;
import by.alex.task04.controller.command.CommandName;
import by.alex.task04.domain.Account;
import by.alex.task04.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

public class ApplicationMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMenuImpl.class);
    public static final ApplicationMenu APPLICATION_MENU = new ApplicationMenuImpl();

    private ApplicationMenuImpl() {
    }

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.MENU)
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.CALCULATE_ACC_BALANCE)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.CALCULATE_ACTIVE_ACC_BALANCE)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.CALCULATE_BLOCKED_ACC_BALANCE)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.CHANGE_ACC_STATUS)
                    + "\n5. " + MessageManager.INSTANCE.getMessage(MessageConstant.FIND_ACC_BY_BALANCE)
                    + "\n6. " + MessageManager.INSTANCE.getMessage(MessageConstant.FIND_ACC_BY_NUMBER)
                    + "\n7. " + MessageManager.INSTANCE.getMessage(MessageConstant.SORT_ACC_BY_BALANCE_ASC)
                    + "\n8. " + MessageManager.INSTANCE.getMessage(MessageConstant.SORT_ACC_BY_BALANCE_DESC)
                    + "\n9. " + MessageManager.INSTANCE.getMessage(MessageConstant.CHANGE_LOCALE)
                    + "\n10. " + MessageManager.INSTANCE.getMessage(MessageConstant.VIEW_ALL_ACC)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.EXIT));
            try {
                input = InputReader.readInt();
                handleUserInput(input);
            } catch (InputMismatchException e) {
                ConsoleWriter.writeln("[" + "]");
                InputReader.readLine();
            }
        }
    }

    @Override
    public void handleUserInput(int input) {
        LOGGER.info("handling user input");
        switch (input) {
            case 1:
                Controller.CONTROLLER.handleRequest(CommandName.CALCULATE_ACCOUNTS_BALANCE);
                break;
            case 2:
                Controller.CONTROLLER.handleRequest(CommandName.CALCULATE_ACTIVE_ACCOUNT_BALANCE);
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.CALCULATE_BLOCKED_ACCOUNT_BALANCE);
                break;
            case 4:
                Controller.CONTROLLER.handleRequest(CommandName.CHANGE_ACCOUNT_STATUS);
                break;
            case 5:
                Controller.CONTROLLER.handleRequest(CommandName.FIND_ACCOUNT_BY_BALANCE);
                break;
            case 6:
                Controller.CONTROLLER.handleRequest(CommandName.FIND_ACCOUNT_BY_NUMBER);
                break;
            case 7:
                Controller.CONTROLLER.handleRequest(CommandName.SORT_ACCOUNT_BY_BALANCE_ASC);
                break;
            case 8:
                Controller.CONTROLLER.handleRequest(CommandName.SORT_ACCOUNT_BY_BALANCE_DESC);
                break;
            case 9:
                Controller.CONTROLLER.handleRequest(CommandName.CHANGE_LOCALE);
                break;
            case 10:
                System.out.println(ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Account.class));
                break;
            case 0:
                ConsoleWriter.writeln("[" + "...]");
                System.exit(-1);
                break;
            default:
                ConsoleWriter.writeln("[" + "]");
                break;
        }
    }

}
