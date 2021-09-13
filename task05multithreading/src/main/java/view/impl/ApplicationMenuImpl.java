package view.impl;

import controller.Controller;
import controller.command.CommandName;
import view.ApplicationMenu;
import view.InputReader;

public class ApplicationMenuImpl implements ApplicationMenu {

    public static final ApplicationMenu APPLICATION_MENU = new ApplicationMenuImpl();

    @Override
    public void print() {
        System.out.println("1.Countdown" +
                "\n2.Lock" +
                "\n3.Phaser" +
                "\n4.Semaphore" +
                "\n0.Exit");
    }

    @Override
    public void handleInput() {
        int input = 0;
        input = InputReader.readInt();
        switch (input) {
            case 1:
                Controller.CONTROLLER.handleRequest(CommandName.MATRIX_COUNTDOWN_FILL);
                break;
            case 2:
                Controller.CONTROLLER.handleRequest(CommandName.MATRIX_LOCK_FILL);
                break;
            case 3:
                Controller.CONTROLLER.handleRequest(CommandName.MATRIX_PHASER_FILL);
                break;
            case 4:
                Controller.CONTROLLER.handleRequest(CommandName.MATRIX_SEMAPHORE_FILL);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }


}
