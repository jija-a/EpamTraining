package by.alex.task06.dao.parser.impl;

import by.alex.task06.dao.parser.FigureParser;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.creator.FigureCreatorFactory;
import by.alex.task06.service.validator.FigureValidator;
import by.alex.task06.service.validator.PointValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class PointParserImpl implements FigureParser<CustomPoint> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PointParserImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final PointParserImpl PARSER = new PointParserImpl();

    /**
     * Regular expression for space symbol.
     */
    private static final String SPACE_REGEX = "\\s";

    /**
     * {@link FigureValidator} instance.
     */
    private final FigureValidator validator;

    /**
     * Private class constructor.
     */
    private PointParserImpl() {
        validator = new PointValidator();
    }

    /**
     * @see FigureParser
     */
    @Override
    public List<CustomPoint> parse(final List<String> string) {

        List<CustomPoint> points = new ArrayList<>();
        for (String line : string) {
            LOGGER.info("Parsing points file line: {}", line);
            if (!validator.isFileLineMatchesRegex(line)) {
                LOGGER.warn("Wrong values in point file line: {}", line);
                break;
            }

            String[] data = line.split(SPACE_REGEX);
            double xCoordinate = Double.parseDouble(data[0]);
            double yCoordinate = Double.parseDouble(data[1]);
            CustomPoint point = FigureCreatorFactory.getPointCreator()
                    .create(xCoordinate, yCoordinate);

            points.add(point);
        }

        return points;
    }

}
