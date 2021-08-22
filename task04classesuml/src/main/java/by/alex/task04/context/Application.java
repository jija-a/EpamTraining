package by.alex.task04.context;

import by.alex.task04.context.config.ApplicationConfig;
import by.alex.task04.context.impl.ApplicationContextImpl;
import by.alex.task04.view.impl.ApplicationMainMenuImpl;

public interface Application {

    static void start() throws InitializingException {

        ApplicationConfig.APPLICATION_CONFIG.init();
        ApplicationContextImpl.APPLICATION_CONTEXT.init();
        ApplicationMainMenuImpl.APPLICATION_MENU.printAvailableOptions();
    }

}
