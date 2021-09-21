package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindTriangleName extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindTriangleName.class);

    /**
     * {@link by.alex.task06.domain.Figure} name.
     */
    private final String name;

    /**
     * Class constructor.
     *
     * @param nameValue - {@link by.alex.task06.domain.Figure} name
     */
    public FindTriangleName(final String nameValue) {
        this.name = nameValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        LOGGER.info("Searching for triangle specified by name");
        return name.equals(triangle.getName());
    }
}
