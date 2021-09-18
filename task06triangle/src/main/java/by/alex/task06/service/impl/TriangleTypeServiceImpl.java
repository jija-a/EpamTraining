package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleTypeServiceImpl implements TriangleTypeService {

    public static final TriangleTypeService SERVICE = new TriangleTypeServiceImpl();

    private TriangleTypeServiceImpl() {
    }

    @Override
    public List<Triangle.TriangleType> defineTriangleType(Triangle triangle) {

        List<Triangle.TriangleType> types = new ArrayList<>();
        List<CustomPoint> points = triangle.getPoints();

        double a = this.createLine(points.get(0), points.get(1));
        double b = this.createLine(points.get(1), points.get(2));
        double c = this.createLine(points.get(2), points.get(0));

        Triangle.TriangleType angleType = this.defineAngleType(a, b, c);
        Optional<Triangle.TriangleType> sidesType = this.defineSidesType(a, b, c);

        types.add(angleType);
        sidesType.ifPresent(types::add);
        return types;
    }

    private Optional<Triangle.TriangleType> defineSidesType(double a, double b, double c) {

        Triangle.TriangleType type = null;

        if (a == b && a == c) {
            type = Triangle.TriangleType.EQUILATERAL;
        } else if (a == b || a == c || b == c) {
            type = Triangle.TriangleType.ISOSCELES;
        }

        return Optional.ofNullable(type);
    }

    private Triangle.TriangleType defineAngleType(double a, double b, double c) {

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

        return type;
    }

    private double createLine(CustomPoint p1, CustomPoint p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

}
