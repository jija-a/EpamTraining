package com.epam.task01.context;

import com.epam.task01.context.impl.ApplicationMainMenu;

public interface Application {

    static void run() {
        ApplicationMainMenu.DEFAULT_MENU.printAvailableOptions();
    }

}
