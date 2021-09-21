package by.alex.task06.service.creator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FigureCreatorFactory {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FigureCreatorFactory.class);

    /**
     * Private class constructor.
     */
    private FigureCreatorFactory() {
    }

    /**
     * Method to return {@link PointCreator} instance.
     *
     * @return {@link PointCreator}
     */
    public static PointCreator getPointCreator() {
        LOGGER.trace("Returning point creator instance");
        return PointCreator.CREATOR;
    }


    /**
     * Method to return {@link TriangleCreator} instance.
     *
     * @return {@link TriangleCreator}
     */
    public static TriangleCreator getTriangleCreator() {
        LOGGER.trace("Returning triangle creator instance");
        return TriangleCreator.CREATOR;
    }

    /**
     * Method to return {@link CircleCreator} instance.
     *
     * @return {@link CircleCreator}
     */
    public static CircleCreator getCircleCreator() {
        LOGGER.trace("Returning circle creator instance");
        return CircleCreator.CREATOR;
    }
}
