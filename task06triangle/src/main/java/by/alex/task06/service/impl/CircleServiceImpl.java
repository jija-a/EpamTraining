package by.alex.task06.service.impl;

import by.alex.task06.domain.Circle;
import by.alex.task06.service.CircleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CircleServiceImpl implements CircleService {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CircleServiceImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final CircleService SERVICE = new CircleServiceImpl();

    private CircleServiceImpl() {
    }

    /**
     * @see CircleService
     */
    @Override
    public double calcArea(final Circle circle) {

        LOGGER.trace("Calculating circle area");
        double radius = circle.getRadius();
        return Math.PI * radius * radius;
    }

    /**
     * @see CircleService
     */
    @Override
    public double calcPerimeter(final Circle circle) {

        LOGGER.trace("Calculating circle perimeter");
        double radius = circle.getRadius();
        return 2 * Math.PI * radius;
    }

    /**
     * @see CircleService
     */
    @Override
    public boolean isCircleCrossesOnlyOneAxis(final Circle circle) {

        LOGGER.trace("Defining if circle crosses axis");
        double radius = circle.getRadius();
        double x = circle.getCenterPoint().getX();
        double y = circle.getCenterPoint().getY();

        return (x > radius && y < radius) || (x < radius && y > radius);
    }
}
