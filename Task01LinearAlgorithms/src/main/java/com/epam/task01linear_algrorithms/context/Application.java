package com.epam.task01linear_algrorithms.context;

import com.epam.task01linear_algrorithms.context.impl.ApplicationMainMenu;

public interface Application {

    static void run() {
        ApplicationMainMenu.DEFAULT_MENU.printAvailableOptions();
    }

}
