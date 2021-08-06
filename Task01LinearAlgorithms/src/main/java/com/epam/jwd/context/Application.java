package com.epam.jwd.context;

import com.epam.jwd.context.impl.DefaultMenu;

public interface Application {

    static void run() {
        DefaultMenu.DEFAULT_MENU.printAvailableOptions();
    }

}
