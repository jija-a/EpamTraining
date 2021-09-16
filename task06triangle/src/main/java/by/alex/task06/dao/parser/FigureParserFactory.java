package by.alex.task06.dao.parser;

import by.alex.task06.dao.parser.impl.CircleParserImpl;
import by.alex.task06.dao.parser.impl.PointParserImpl;
import by.alex.task06.dao.parser.impl.TriangleParserImpl;
import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;

public class FigureParserFactory {

    public static final FigureParserFactory PARSER_FACTORY = new FigureParserFactory();

    private FigureParserFactory() {
    }

    public FigureParser<Triangle> getTriangleParser() {
        return TriangleParserImpl.PARSER;
    }

    public FigureParser<CustomPoint> getPointsParser() {
        return PointParserImpl.PARSER;
    }

    public FigureParser<Circle> getCirclesParser() {
        return CircleParserImpl.PARSER;
    }
}
