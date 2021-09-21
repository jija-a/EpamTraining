package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class TriangleTypeServiceImpl implements TriangleTypeService {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleTypeServiceImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final TriangleTypeService SERVICE =
            new TriangleTypeServiceImpl();

    /**
     * Private class constructor.
     */
    private TriangleTypeServiceImpl() {
    }

    @Override
    public List<Triangle.TriangleType> defineType(final Triangle triangle) {

        LOGGER.trace("Defining triangle type");
        List<Triangle.TriangleType> types = new ArrayList<>();
        List<CustomPoint> points = triangle.getPoints();

        double a = this.createLine(points.get(0), points.get(1));
        double b = this.createLine(points.get(1), points.get(2));
        double c = this.createLine(points.get(2), points.get(0));

        Triangle.TriangleType angleType = this.defineAngleType(a, b, c);
        Optional<Triangle.TriangleType> sidesType =
                this.defineSidesType(a, b, c);

        types.add(angleType);
        sidesType.ifPresent(types::add);
        return types;
    }

    private Optional<Triangle.TriangleType> defineSidesType(final double a,
                                                            final double b,
                                                            final double c) {

        Triangle.TriangleType type = null;

        if (a == b && a == c) {
            type = Triangle.TriangleType.EQUILATERAL;
        } else if (a == b || a == c || b == c) {
            type = Triangle.TriangleType.ISOSCELES;
        }

        LOGGER.trace("Triangle sides type: {}", type);
        return Optional.ofNullable(type);
    }

    private Triangle.TriangleType defineAngleType(final double a,
                                                  final double b,
                                                  final double c) {

        Triangle.TriangleType type = Triangle.TriangleType.OBTUSE;
        double max = Math.max(a, b);
        max = Math.max(c, max);

        if (2 * max < a + b + c) {
            double t = a * a + b * b + c * c - 2 * max * max;
            if (t > 0) {
                type = Triangle.TriangleType.SHARP_ANGLED;
            } else if (t == 0) {
                type = Triangle.TriangleType.RECTANGULAR;
            }
        }

        LOGGER.trace("Triangle angle type: {}", type);
        return type;
    }

    private double createLine(final CustomPoint p1, final CustomPoint p2) {
        LOGGER.trace("Creating triangle line");
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

}
