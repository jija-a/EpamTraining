package com.epam.task02;

import com.epam.task02.context.Application;
import com.epam.task02.util.MessageConstant;
import com.epam.task02.util.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            LOGGER.info("Application start");
            Application.run();
        } catch (Exception e) {
            LOGGER.info("Application failed to start: ", e);
            System.out.println(MessageManager.INSTANCE.getMessage(MessageConstant.MAIN_ERROR_FAILED_TO_START_APP));
        }

    }

}
