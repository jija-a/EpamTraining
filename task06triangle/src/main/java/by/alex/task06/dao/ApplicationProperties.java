package by.alex.task06.dao;

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
     * This class instance (Singleton pattern).
     */
    public static final ApplicationProperties PROPERTIES =
            new ApplicationProperties();

    /**
     * Path to triangle data file.
     */
    private String trianglesFilePath;

    /**
     * Path to points data file.
     */
    private String pointsFilePath;

    /**
     * Path to circles data file.
     */
    private String circlesFilePath;

    /**
     * Class constructor.
     */
    private ApplicationProperties() {
        init();
    }

    /**
     * Method to initialize class fields from
     * application.properties file.
     */
    private void init() throws InitializingError {
        LOGGER.trace("Initializing application configuration");
        try {
            ResourceBundle rb = ResourceBundle
                    .getBundle("application");

            trianglesFilePath = rb.getString("application.file_path.triangles");
            pointsFilePath = rb.getString("application.file_path.points");
            circlesFilePath = rb.getString("application.file_path.circles");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            throw new InitializingError("Error while "
                    + "initializing application configuration", e);
        }
    }

    /**
     * Field getter.
     *
     * @return String trianglesFilePath
     */
    public String getTrianglesFilePath() {
        return trianglesFilePath;
    }


    /**
     * Field getter.
     *
     * @return String pointsFilePath
     */
    public String getPointsFilePath() {
        return pointsFilePath;
    }


    /**
     * Field getter.
     *
     * @return String circlesFilePath
     */
    public String getCirclesFilePath() {
        return circlesFilePath;
    }

}
