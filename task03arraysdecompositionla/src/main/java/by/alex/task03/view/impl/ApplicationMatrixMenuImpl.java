package by.alex.task03.view.impl;

import by.alex.task03.controller.Controller;
import by.alex.task03.controller.command.CommandName;
import by.alex.task03.util.ConsoleWriter;
import by.alex.task03.util.InputReader;
import by.alex.task03.util.MessageConstant;
import by.alex.task03.util.MessageManager;
import by.alex.task03.view.ApplicationMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

public class ApplicationMatrixMenuImpl implements ApplicationMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMatrixMenuImpl.class);
    public static final ApplicationMenu APPLICATION_MENU = new ApplicationMatrixMenuImpl();

    private ApplicationMatrixMenuImpl() {
    }

    @Override
    public void printAvailableOptions() {
        LOGGER.trace("printing available options");
        int input = -1;
        while (input != 0) {
            ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX) + ":"
                    + "\n1. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX_MULTIPLY)
                    + "\n2. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX_SUM)
                    + "\n3. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX_SUBTRACT)
                    + "\n4. " + MessageManager.INSTANCE.getMessage(MessageConstant.MENU_MATRIX_TRANSPOSE)
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
                Controller.CONTROLLER.handleRequest(CommandName.MULTIPLY_MATRIX);
                break;
            case 2:
                Controller.CONTROLLER.handleRequest(CommandName.SUM_MATRIX);
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.SUBTRACT_MATRIX);
                break;
            case 4:
                Controller.CONTROLLER.handleRequest(CommandName.TRANSPOSE_MATRIX);
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
