package by.alex.task04.context.config;

import by.alex.task04.context.InitializingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final ApplicationConfig APPLICATION_CONFIG = new ApplicationConfig();

    private static String inputDir;
    private static String accountsFileName;

    private ApplicationConfig() {
    }

    public void init() throws InitializingException {
        LOGGER.trace("Initializing application configuration");
        try {
            ResourceBundle rb = ResourceBundle.getBundle("application");
            inputDir = rb.getString("application.input_dir");
            accountsFileName = rb.getString("application.account_file_name");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            LOGGER.error("Error while initializing application configuration", e);
            throw new InitializingException("Error while initializing application configuration", e);
        }
    }

    public static String getInputDir() {
        return inputDir;
    }

    public static String getAccountsFileName() {
        return accountsFileName;
    }

}
