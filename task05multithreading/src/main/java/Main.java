import view.impl.ApplicationMenuImpl;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        while (true) {
            ApplicationMenuImpl.APPLICATION_MENU.print();
            ApplicationMenuImpl.APPLICATION_MENU.handleInput();
        }

    }

}
