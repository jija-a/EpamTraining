package by.alex.task06.service.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PointValidator implements FigureValidator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PointValidator.class);

    /**
     * Regular expression for point file line.
     */
    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)\\s(-?\\d+(\\.\\d+)?)";

    /**
     * @see FigureValidator
     */
    @Override
    public boolean isFileLineMatchesRegex(final String line) {
        LOGGER.info("Validating points file line: {}", line);
        return line.matches(FILE_LINE_REGEX);
    }
}
