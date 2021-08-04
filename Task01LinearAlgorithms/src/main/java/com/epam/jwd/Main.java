package com.epam.jwd;

import com.epam.jwd.context.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin.dom.exception.InvalidStateException;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            LOGGER.debug("Starting application");
            Application.run();
        } catch (InvalidStateException e) {
            LOGGER.error("Failed to start application: ", e);
            e.printStackTrace();
        }
    }

}
