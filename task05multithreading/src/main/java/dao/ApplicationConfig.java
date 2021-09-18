package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.InitializingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final ApplicationConfig CONFIG = new ApplicationConfig();

    private static String matrixFilePath;
    private static String threadFilePath;

    public ApplicationConfig() {
        init();
    }

    private static void init() throws InitializingException {
        try (InputStream input = new FileInputStream("task05multithreading/src/main/resources/application.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            threadFilePath = prop.getProperty("application.file_path.thread");
            matrixFilePath = prop.getProperty("application.file_path.matrix");

        } catch (IOException e) {
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
