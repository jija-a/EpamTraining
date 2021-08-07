package com.epam.task01;

import com.epam.task01.context.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            LOGGER.info("Start application");
            Application.run();
        } catch (Exception e) {
            LOGGER.error("Failed to start application: ", e);
            System.out.println("Failed to start application");
        }
    }

}
