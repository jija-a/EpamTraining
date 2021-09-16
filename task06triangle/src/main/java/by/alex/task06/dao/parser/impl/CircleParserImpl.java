package by.alex.task06.dao.parser.impl;

import by.alex.task06.dao.parser.FigureParser;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.creator.FigureCreatorFactory;
import by.alex.task06.service.validator.CircleValidator;
import by.alex.task06.service.validator.FigureValidator;

import java.util.ArrayList;
import java.util.List;

public final class CircleParserImpl implements FigureParser<Circle> {

    public static final CircleParserImpl PARSER = new CircleParserImpl();

    private static final String SPACE_REGEX = "\\s";

    private final FigureValidator validator;

    private CircleParserImpl() {
        validator = new CircleValidator();
    }

    @Override
    public List<Circle> parse(final List<String> string) {

        List<Circle> circles = new ArrayList<>();

        for (String line : string) {
            if (validator.validateFileLineRegex(line)) {
                String[] data = line.split(SPACE_REGEX);
                List<String> pointsLine = new ArrayList<>();
                pointsLine.add(data[0] + " " + data[1]);
                List<CustomPoint> points = FigureParserFactory.PARSER_FACTORY
                        .getPointsParser().parse(pointsLine);

                if (!points.isEmpty()) {
                    CustomPoint centerPoint = points.get(0);
                    double radius = Double.parseDouble(data[2]);

                    Circle circle = FigureCreatorFactory.getCircleCreator()
                            .create(centerPoint, radius);
                    circles.add(circle);
                }
            }
        }

        return circles;
    }
}
