package by.alex.task03.context;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.exception.InvalidStateException;

public interface Application {

    static void start() throws InvalidStateException {

        ApplicationContextImpl.APPLICATION_CONTEXT.init();
        ApplicationMenu.printAvailableOptions();
    }

}
