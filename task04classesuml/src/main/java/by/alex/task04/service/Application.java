package by.alex.task04.service;

import by.alex.task04.context.config.ApplicationConfig;
import by.alex.task04.context.impl.ApplicationContextImpl;
import by.alex.task04.view.impl.ApplicationMenuImpl;

public interface Application {


    static void start() {

        ApplicationConfig.APPLICATION_CONFIG.init();
        ApplicationContextImpl.APPLICATION_CONTEXT.init();
        ApplicationMenuImpl.APPLICATION_MENU.printAvailableOptions();
    }

}
