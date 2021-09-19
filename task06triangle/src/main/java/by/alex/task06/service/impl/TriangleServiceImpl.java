package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleService;

import java.util.List;

public final class TriangleServiceImpl implements TriangleService {

    public static final TriangleServiceImpl SERVICE = new TriangleServiceImpl();

    private TriangleServiceImpl() {
    }


    @Override
    public double calcArea(final Triangle triangle) {

        List<CustomPoint> points = triangle.getPoints();

        double a = this.createLine(points.get(0), points.get(1));
        double b = this.createLine(points.get(1), points.get(2));
        double c = this.createLine(points.get(2), points.get(0));

        double hPerimeter = (a + b + c) / 2;
        return Math.sqrt(hPerimeter * (hPerimeter - a)
                * (hPerimeter - b) * (hPerimeter - c));
    }

    @Override
    public double calcPerimeter(final Triangle triangle) {

        List<CustomPoint> points = triangle.getPoints();

        double a = this.createLine(points.get(0), points.get(1));
        double b = this.createLine(points.get(1), points.get(2));
        double c = this.createLine(points.get(2), points.get(0));

        return a + b + c;
    }

    private double createLine(final CustomPoint p1, final CustomPoint p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}
