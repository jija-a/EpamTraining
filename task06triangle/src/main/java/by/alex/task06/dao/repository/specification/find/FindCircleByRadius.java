package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindCircleByRadius extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindCircleByRadius.class);

    /**
     * Lowest value of radius.
     */
    private final double from;

    /**
     * Highest value of radius.
     */
    private final double to;

    /**
     * Class constructor.
     *
     * @param fromValue - lowest value
     * @param toValue   - highest value
     */
    public FindCircleByRadius(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {
        LOGGER.info("Searching for circle specified by radius");
        double circleRadius = circle.getRadius();
        return circleRadius >= from && circleRadius <= to;
    }
}
