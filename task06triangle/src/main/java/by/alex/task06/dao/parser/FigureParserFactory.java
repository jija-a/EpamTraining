package by.alex.task06.dao.parser;

import by.alex.task06.dao.parser.impl.CircleParserImpl;
import by.alex.task06.dao.parser.impl.PointParserImpl;
import by.alex.task06.dao.parser.impl.TriangleParserImpl;
import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FigureParserFactory {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FigureParserFactory.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final FigureParserFactory FACTORY = new FigureParserFactory();

    /**
     * Private class constructor.
     */
    private FigureParserFactory() {
    }

    /**
     * Method to return {@link TriangleParserImpl} instance.
     *
     * @return {@link TriangleParserImpl}
     */
    public FigureParser<Triangle> getTriangleParser() {
        LOGGER.trace("Returning triangles parser instance");
        return TriangleParserImpl.PARSER;
    }

    /**
     * Method to return {@link PointParserImpl} instance.
     *
     * @return {@link PointParserImpl}
     */
    public FigureParser<CustomPoint> getPointsParser() {
        LOGGER.trace("Returning points parser instance");
        return PointParserImpl.PARSER;
    }

    /**
     * Method to return {@link CircleParserImpl} instance.
     *
     * @return {@link CircleParserImpl}
     */
    public FigureParser<Circle> getCirclesParser() {
        LOGGER.trace("Returning circles parser instance");
        return CircleParserImpl.PARSER;
    }
}
