package by.alex.task06.dao.parser.impl;

import by.alex.task06.dao.parser.FigureParser;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.creator.FigureCreatorFactory;
import by.alex.task06.service.creator.WrongArgumentsException;
import by.alex.task06.service.validator.CircleValidator;
import by.alex.task06.service.validator.FigureValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public final class CircleParserImpl implements FigureParser<Circle> {

    public static final CircleParserImpl PARSER = new CircleParserImpl();

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CircleParserImpl.class);

    private static final String SPACE_REGEX = "\\s";

    private final FigureValidator validator;

    private CircleParserImpl() {
        validator = new CircleValidator();
    }

    @Override
    public List<Circle> parse(final List<String> string) {

        List<Circle> circles = new ArrayList<>();

        for (String line : string) {
            if (validator.isFileLineMatchesRegex(line)) {
                String[] data = line.split(SPACE_REGEX);
                List<String> pointsLine = new ArrayList<>();
                pointsLine.add(data[0] + " " + data[1]);
                List<CustomPoint> points = FigureParserFactory.FACTORY
                        .getPointsParser().parse(pointsLine);

                if (!points.isEmpty()) {
                    CustomPoint centerPoint = points.get(0);
                    double radius = Double.parseDouble(data[2]);

                    try {
                        Circle circle = FigureCreatorFactory.getCircleCreator()
                                .create(centerPoint, radius);
                        circles.add(circle);
                    } catch (WrongArgumentsException e) {
                        LOGGER.warn("Creator provided exception", e);
                    }
                }

            }
        }

        return circles;
    }

}
