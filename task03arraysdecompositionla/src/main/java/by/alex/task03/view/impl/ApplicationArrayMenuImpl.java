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

public class ApplicationArrayMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationArrayMenuImpl.class);
    public static final ApplicationMenu APPLICATION_MENU = new ApplicationArrayMenuImpl();

    private ApplicationArrayMenuImpl() {
    }

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY) + ":"
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_BUBBLE_SORT)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_SHAKER_SORT)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_SELECTION_SORT)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_INSERTION_SIMPLE_SORT)
                    + "\n5. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_MERGE_SORT)
                    + "\n6. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_SHELL_SORT)
                    + "\n7. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_ARRAY_EXTERNAL_SORT)
                    + "\n0. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN_BACK));
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
                Controller.CONTROLLER.handleRequest(CommandName.BUBBLE_SORT);
                break;
            case 2:
                Controller.CONTROLLER.handleRequest(CommandName.SHAKER_SORT);
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.SELECTION_SORT);
                break;
            case 4:
                Controller.CONTROLLER.handleRequest(CommandName.INSERTION_SORT);
                break;
            case 5:
                Controller.CONTROLLER.handleRequest(CommandName.MERGE_SORT);
                break;
            case 6:
                Controller.CONTROLLER.handleRequest(CommandName.SHELL_SORT);
                break;
            case 7:
                Controller.CONTROLLER.handleRequest(CommandName.EXTERNAL_SORT);
                break;
            case 0:
                ConsoleWriter.writeln("["
                        + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MAIN_BACK)
                        + "...]");
                break;
            default:
                ConsoleWriter.writeln("["
                        + MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_ERROR_NO_SUCH_COMMAND)
                        + "]");
                break;
        }
    }

}
