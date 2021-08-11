package com.epam.task02.context;

import com.epam.task02.context.impl.ApplicationContextImpl;
import com.epam.task02.context.impl.ApplicationMainMenuImpl;
import com.epam.task02.exception.InvalidStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Application {

    Logger LOGGER = LoggerFactory.getLogger(Application.class);

    static void run() throws InvalidStateException {
        LOGGER.debug("Application initializing");
        ApplicationContextImpl.APPLICATION_CONTEXT.init();
        LOGGER.info("Application initialized");
        ApplicationMainMenuImpl.APPLICATION_MENU.printAvailableOptions();
    }


}
