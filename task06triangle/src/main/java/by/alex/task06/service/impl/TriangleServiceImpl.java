package by.alex.task06.service.impl;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.TriangleService;

public class TriangleServiceImpl implements TriangleService {

    public static final TriangleServiceImpl SERVICE = new TriangleServiceImpl();

    private TriangleServiceImpl() {
    }


    @Override
    public double calcArea(Triangle triangle) {

        double a = createLine(triangle.getPoints().get(0), triangle.getPoints().get(1));
        double b = createLine(triangle.getPoints().get(1), triangle.getPoints().get(2));
        double c = createLine(triangle.getPoints().get(2), triangle.getPoints().get(0));

        double hPerimeter = (a + b + c) / 2;
        return Math.sqrt(hPerimeter * (hPerimeter - a)
                * (hPerimeter - b) * (hPerimeter - c));
    }

    @Override
    public double calcPerimeter(Triangle triangle) {

        double a = createLine(triangle.getPoints().get(0), triangle.getPoints().get(1));
        double b = createLine(triangle.getPoints().get(1), triangle.getPoints().get(2));
        double c = createLine(triangle.getPoints().get(2), triangle.getPoints().get(0));

        return a + b + c;
    }

    private double createLine(CustomPoint p1, CustomPoint p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}
