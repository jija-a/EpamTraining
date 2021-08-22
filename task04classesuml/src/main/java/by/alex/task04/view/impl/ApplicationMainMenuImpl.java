package by.alex.task04.view.impl;

import by.alex.task04.controller.Controller;
import by.alex.task04.controller.command.CommandName;
import by.alex.task04.util.ConsoleWriter;
import by.alex.task04.util.InputReader;
import by.alex.task04.view.ApplicationMenu;
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
            ConsoleWriter.write("");
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

                break;
            case 2:
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.CHANGE_LOCALE);
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
