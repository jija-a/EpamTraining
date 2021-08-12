package by.alex.task03.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderUtil {

    private static final Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyReaderUtil.class);

    private PropertyReaderUtil() {
    }

    public static String loadProperty(String property) {
        String toReturn = null;
        final String propertiesFileName = "task03arraysdecompositionla/src/main/resources/application.properties";

        try {
            properties.load(new FileInputStream(propertiesFileName));
            toReturn = properties.getProperty(property);
        } catch (IOException e) {
            System.out.println("File Properties non exist");
            LOGGER.error("File Properties non exist", e);
        }

        return toReturn;
    }

}
