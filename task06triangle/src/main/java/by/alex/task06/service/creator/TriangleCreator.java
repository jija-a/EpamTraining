package by.alex.task06.service.creator;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.validator.TriangleValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class TriangleCreator {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleCreator.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final TriangleCreator CREATOR = new TriangleCreator();

    /**
     * {@link TriangleValidator} instance.
     */
    private final TriangleValidator validator;

    /**
     * Private constructor.
     */
    private TriangleCreator() {
        this.validator = new TriangleValidator();
    }

    /**
     * Method to create {@link Triangle}.
     *
     * @param points - {@link List} of triangle points
     * @param name   - {@link String} triangle name
     * @return new {@link Triangle} object
     */
    public Triangle create(final List<CustomPoint> points, final String name)
            throws WrongArgumentsException {

        if (validator.isTriangleExists(points)) {
            Triangle triangle = new Triangle(points, name);
            List<Triangle.TriangleType> types = ServiceFactory.FACTORY
                    .getTriangleTypesService().defineType(triangle);
            triangle.setTypes(types);
            LOGGER.info("Triangle created: {}", triangle);
            return triangle;
        }
        throw new WrongArgumentsException("Unable to create triangle. "
                + "It does not exist");
    }

}
