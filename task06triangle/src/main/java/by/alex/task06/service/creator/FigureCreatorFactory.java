package by.alex.task06.service.creator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FigureCreatorFactory {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FigureCreatorFactory.class);

    private FigureCreatorFactory() {
    }

    public static PointCreator getPointCreator() {
        LOGGER.info("Returning point creator instance");
        return PointCreator.CREATOR;
    }

    public static TriangleCreator getTriangleCreator() {
        LOGGER.info("Returning triangle creator instance");
        return TriangleCreator.CREATOR;
    }

    public static CircleCreator getCircleCreator() {
        LOGGER.info("Returning circle creator instance");
        return CircleCreator.CREATOR;
    }

}
