package com.epam.task07.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class ApplicationProperties {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApplicationProperties.class);

    /**
     * Instance of this class (Singleton pattern).
     */
    public static final ApplicationProperties PROPERTIES =
            new ApplicationProperties();

    /**
     * Input files directory path.
     */
    private String inputDir;

    /**
     * Text file path.
     */
    private String textFileName;

    private ApplicationProperties() {
        init();
    }

    /**
     * Method read application.properties file and initializes class fields.
     */
    public void init() throws InitializingError {
        LOGGER.info("Initializing application configuration");
        try {
            ResourceBundle rb = ResourceBundle.getBundle("application");
            inputDir = rb.getString("application.dir.name");
            textFileName = rb.getString("application.file.name.text");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            throw new InitializingError("Error while initializing "
                    + "application configuration", e);
        }
    }

    /**
     * Method to get input directory path.
     *
     * @return {@link String} path
     */
    public String getInputDir() {
        return this.inputDir;
    }

    /**
     * Method to get file name.
     *
     * @return {@link String} name
     */
    public String getTextFileName() {
        return this.textFileName;
    }
}
