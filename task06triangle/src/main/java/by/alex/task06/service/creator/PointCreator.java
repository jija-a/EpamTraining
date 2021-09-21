package by.alex.task06.service.creator;

import by.alex.task06.domain.CustomPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PointCreator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PointCreator.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final PointCreator CREATOR = new PointCreator();

    /**
     * Private class constructor.
     */
    private PointCreator() {
    }

    /**
     * Method to create {@link CustomPoint}.
     *
     * @param x - x axis point position
     * @param y - y axis point position
     * @return {@link CustomPoint}
     */
    public CustomPoint create(final double x, final double y) {

        CustomPoint point = new CustomPoint(x, y);
        LOGGER.info("CustomPoint created: {}", point);
        return point;
    }
}
