package com.epam.task02.context;

import com.epam.task02.context.impl.ApplicationMainMenuImpl;
import com.epam.task02.util.MessageManager;

public interface Application {

    static void run() {
        ApplicationMainMenuImpl.APPLICATION_MENU.printAvailableOptions();
    }

}
