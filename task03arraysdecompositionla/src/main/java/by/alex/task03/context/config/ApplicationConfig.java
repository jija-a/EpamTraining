package by.alex.task03.context.config;

import by.alex.task03.context.InitializingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final ApplicationConfig APPLICATION_CONFIG = new ApplicationConfig();

    private static String inputDir;
    private static String arrayFileName;
    private static String matrixFileName;

    private ApplicationConfig() {
    }

    public void init() throws InitializingException {
        LOGGER.trace("Initializing application configuration");
        try {
            ResourceBundle rb = ResourceBundle.getBundle("application");
            inputDir = rb.getString("application.input_dir");
            arrayFileName = rb.getString("application.array_file_name");
            matrixFileName = rb.getString("application.matrix_file_name");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            LOGGER.error("Error while initializing application configuration", e);
            throw new InitializingException("Error while initializing application configuration", e);
        }
    }

    public static String getInputDir() {
        return inputDir;
    }

    public static String getArrayFileName() {
        return arrayFileName;
    }

    public static String getMatrixFileName() {
        return matrixFileName;
    }

}
