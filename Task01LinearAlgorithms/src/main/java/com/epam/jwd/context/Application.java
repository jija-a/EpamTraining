package com.epam.jwd.context;

import com.epam.jwd.context.impl.DefaultMenu;

public interface Application {

    static void run() {
        ApplicationMenu applicationMenu = new DefaultMenu();
        applicationMenu.printAvailableOptions();
    }

}
