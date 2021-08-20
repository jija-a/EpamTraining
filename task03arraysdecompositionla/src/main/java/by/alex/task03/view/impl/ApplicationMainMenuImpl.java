package by.alex.task03.view.impl;

import by.alex.task03.controller.Controller;
import by.alex.task03.controller.command.CommandName;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
import by.alex.task03.view.ApplicationMenu;
import by.alex.task03.util.InputReader;
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
            ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN) + ": "
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN_CHANGE_LOCALE)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN_EXIT));
            try {
                input = InputReader.readInt();
                handleUserInput(input);
            } catch (InputMismatchException e) {
                ConsoleWriter.writeln("["
                        + MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_NO_SUCH_COMMAND)
                        + "]");
                InputReader.readLine();
            }
        }
    }

    @Override
    public void handleUserInput(int input) {
        LOGGER.info("handling user input");
        switch (input) {
            case 1:
                ApplicationMatrixMenuImpl.APPLICATION_MENU.printAvailableOptions();
                break;
            case 2:
                ApplicationArrayMenuImpl.APPLICATION_MENU.printAvailableOptions();
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.CHANGE_LOCALE);
                break;
            case 0:
                ConsoleWriter.writeln("["
                        + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN_EXIT)
                        + "...]");
                System.exit(-1);
                break;
            default:
                ConsoleWriter.writeln("["
                        + MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_NO_SUCH_COMMAND)
                        + "]");
                break;
        }
    }

}
