package by.alex.task06.dao.parser.impl;

import by.alex.task06.dao.parser.FigureParser;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.creator.FigureCreatorFactory;
import by.alex.task06.service.creator.WrongArgumentsException;
import by.alex.task06.service.validator.FigureValidator;
import by.alex.task06.service.validator.TriangleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class TriangleParserImpl implements FigureParser<Triangle> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleParserImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final TriangleParserImpl PARSER = new TriangleParserImpl();

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
    private TriangleParserImpl() {
        this.validator = new TriangleValidator();
    }

    @Override
    public List<Triangle> parse(final List<String> string) {

        List<Triangle> triangles = new ArrayList<>();

        for (String line : string) {
            LOGGER.info("Parsing triangles file line: {}", line);
            if (!validator.isFileLineMatchesRegex(line)) {
                LOGGER.warn("Wrong values in triangles file line: {}", line);
                continue;
            }

            String[] data = line.split(SPACE_REGEX);
            List<CustomPoint> points = new ArrayList<>();

            for (int i = 0; i < data.length - 1; i = i + 2) {
                List<String> pointLines = new ArrayList<>();
                pointLines.add(data[i] + " " + data[i + 1]);
                points.addAll(FigureParserFactory.FACTORY
                        .getPointsParser().parse(pointLines));
            }

            String name = data[data.length - 1];
            try {
                Triangle triangle = FigureCreatorFactory
                        .getTriangleCreator().create(points, name);
                triangles.add(triangle);
            } catch (WrongArgumentsException e) {
                LOGGER.warn("Creator provided exception: ", e);
            }
        }
        return triangles;
    }

}
