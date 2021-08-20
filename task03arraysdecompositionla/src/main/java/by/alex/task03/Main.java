package by.alex.task03;

import by.alex.task03.context.Application;
import by.alex.task03.context.InitializingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    //todo tests
    public static void main(String[] args) {

        try {
            LOGGER.info("Start application");
            Application.start();
        } catch (InitializingException e) {
            LOGGER.error("Failed to start application: ", e);
            System.out.println("Invalid state of application, exit...");
            System.exit(0);
        }
    }

}
