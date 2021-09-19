package by.alex.task06.service.impl;

import by.alex.task06.domain.Circle;
import by.alex.task06.service.CircleService;

public final class CircleServiceImpl implements CircleService {

    public static final CircleService SERVICE = new CircleServiceImpl();

    private CircleServiceImpl() {
    }

    @Override
    public double calcArea(final Circle circle) {

        double radius = circle.getRadius();
        return Math.PI * radius * radius;
    }

    @Override
    public double calcPerimeter(final Circle circle) {

        double radius = circle.getRadius();
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isCircleCrossesOnlyOneAxis(final Circle circle,
                                              final double distance) {

        double radius = circle.getRadius();
        double x = circle.getCenterPoint().getX();
        double y = circle.getCenterPoint().getY();

        return (x > radius && y < radius) || (x < radius && y > radius);
    }
}
