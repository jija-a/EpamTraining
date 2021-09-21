package by.alex.task06.service.creator;

import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.validator.CircleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CircleCreator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CircleCreator.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final CircleCreator CREATOR = new CircleCreator();

    /**
     * {@link CircleValidator} instance.
     */
    private final CircleValidator validator;

    /**
     * Class constructor.
     */
    private CircleCreator() {
        this.validator = new CircleValidator();
    }

    /**
     * Method to create Circle.
     *
     * @param centerPoint - center point of circle
     * @param radius      - radius of circle
     * @param name
     * @return {@link Circle}
     * @throws WrongArgumentsException - if radius 0 or lesser.
     */
    public Circle create(final CustomPoint centerPoint, final double radius,
                         final String name)
            throws WrongArgumentsException {

        if (validator.isCircleExists(radius)) {
            Circle circle = new Circle(centerPoint, radius, name);
            LOGGER.info("Circle created: {}", circle);
            return circle;
        }
        throw new WrongArgumentsException("Unable to create circle. "
                + "Radius 0 or lesser: " + radius);
    }

}
