package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindTriangleType extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindTriangleType.class);

    /**
     * {@link by.alex.task06.domain.Triangle.TriangleType}.
     */
    private final Triangle.TriangleType type;

    /**
     * Class constructor.
     *
     * @param typeValue - {@link by.alex.task06.domain.Triangle.TriangleType}
     */
    public FindTriangleType(final Triangle.TriangleType typeValue) {
        this.type = typeValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        LOGGER.info("Searching for triangle specified by type");
        boolean toReturn = false;
        for (Triangle.TriangleType triangleType : triangle.getTypes()) {
            if (triangleType.equals(this.type)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }
}
