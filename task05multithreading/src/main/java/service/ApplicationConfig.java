package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final ApplicationConfig CONFIG = new ApplicationConfig();

    private static String matrixFilePath;
    private static String threadFilePath;

    public ApplicationConfig() {
        init();
    }

    private void init() throws InitializingException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("application");
            threadFilePath = rb.getString("application.file_path.thread");
            matrixFilePath = rb.getString("application.file_path.matrix");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            LOGGER.error("Error while initializing application configuration", e);
            throw new InitializingException("Error while initializing application configuration", e);
        }
    }

    public String getMatrixFilePath() {
        return matrixFilePath;
    }

    public String getThreadFilePath() {
        return threadFilePath;
    }

}
