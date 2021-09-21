package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindTriangleById extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindTriangleById.class);

    /**
     * {@link by.alex.task06.domain.Figure} id.
     */
    private final long id;

    /**
     * Class constructor.
     *
     * @param idValue - {@link by.alex.task06.domain.Figure} id
     */
    public FindTriangleById(final long idValue) {
        this.id = idValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        LOGGER.info("Searching for triangle specified by id");
        return id == triangle.getId();
    }
}
