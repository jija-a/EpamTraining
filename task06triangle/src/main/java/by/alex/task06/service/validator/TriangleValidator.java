package by.alex.task06.service.validator;

import by.alex.task06.domain.CustomPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TriangleValidator implements FigureValidator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleValidator.class);

    /**
     * Regular expression for triangle file line.
     */
    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)(?:\\s(-?\\d+(\\.\\d+)?)){5}.+";

    /**
     * @see FigureValidator
     */
    @Override
    public boolean isFileLineMatchesRegex(final String line) {
        LOGGER.info("Validating triangle file line: {}", line);
        return line.matches(FILE_LINE_REGEX);
    }

    /**
     * Method to define if triangle exists.
     *
     * @param points - triangle {@link CustomPoint}
     * @return true if triangle exists, false - if not
     */
    public boolean isTriangleExists(final List<CustomPoint> points) {

        LOGGER.info("Defining if triangle with points: {} exist", points);
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        return Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) != 0;
    }
}
