package by.alex.task06.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircleValidator implements FigureValidator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CircleValidator.class);

    /**
     * Regular expression for circle line.
     */
    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)(?:\\s(-?\\d+(\\.\\d+)?)){2}.+";

    /**
     * @see FigureValidator
     */
    @Override
    public boolean isFileLineMatchesRegex(final String line) {
        LOGGER.info("Validating circle file line: {}", line);
        return line.matches(FILE_LINE_REGEX);
    }

    /**
     * Method to define if circle exists.
     *
     * @param radius - circle radius value.
     * @return true - if circle exists or false - if not
     */
    public boolean isCircleExists(final double radius) {
        LOGGER.info("Defining if circle with radius: {} exist", radius);
        return radius > 0;
    }
}
