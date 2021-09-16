package by.alex.task06.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);
    public static final ApplicationProperties PROPERTIES = new ApplicationProperties();

    private String trianglesFilePath;
    private String pointsFilePath;
    private String circlesFilePath;

    private ApplicationProperties() {
        init();
    }

    private void init() throws InitializingException {
        LOGGER.trace("Initializing application configuration");
        try {
            ResourceBundle rb = ResourceBundle.getBundle("task06triangle/src/main/resources/application.properties");
            trianglesFilePath = rb.getString("application.file_path.triangles");
            pointsFilePath = rb.getString("application.file_path.points");
            circlesFilePath = rb.getString("application.file_path.circles");
        } catch (ExceptionInInitializerError | MissingResourceException e) {
            LOGGER.error("Error while initializing application configuration", e);
            throw new InitializingException("Error while initializing application configuration", e);
        }
    }

    public String getTrianglesFilePath() {
        return trianglesFilePath;
    }

    public String getPointsFilePath() {
        return pointsFilePath;
    }

    public String getCirclesFilePath() {
        return circlesFilePath;
    }

}
