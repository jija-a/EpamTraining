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

    public static final TriangleParserImpl PARSER = new TriangleParserImpl();

    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleParserImpl.class);

    private static final String SPACE_REGEX = "\\s";

    private final FigureValidator validator;

    private TriangleParserImpl() {
        this.validator = new TriangleValidator();
    }

    @Override
    public List<Triangle> parse(final List<String> string) {

        List<Triangle> triangles = new ArrayList<>();

        for (String line : string) {
            if (validator.validateFileLineRegex(line)) {
                String[] data = line.split(SPACE_REGEX);
                List<CustomPoint> points = new ArrayList<>();

                for (int i = 0; i < data.length - 1; i = i + 2) {
                    List<String> pointLines = new ArrayList<>();
                    pointLines.add(data[i] + " " + data[i + 1]);
                    points.addAll(FigureParserFactory.PARSER_FACTORY
                            .getPointsParser().parse(pointLines));
                }

                Triangle triangle = FigureCreatorFactory
                        .getTriangleCreator().create(points, "name");
                triangles.add(triangle);

            }
        }
        return triangles;
    }

}
