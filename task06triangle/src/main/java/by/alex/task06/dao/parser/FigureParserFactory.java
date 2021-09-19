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

    public static final FigureParserFactory FACTORY = new FigureParserFactory();
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FigureParserFactory.class);

    private FigureParserFactory() {
    }

    public FigureParser<Triangle> getTriangleParser() {
        LOGGER.trace("Returning triangles parser");
        return TriangleParserImpl.PARSER;
    }

    public FigureParser<CustomPoint> getPointsParser() {
        LOGGER.trace("Returning points parser");
        return PointParserImpl.PARSER;
    }

    public FigureParser<Circle> getCirclesParser() {
        LOGGER.trace("Returning circles parser");
        return CircleParserImpl.PARSER;
    }
}
