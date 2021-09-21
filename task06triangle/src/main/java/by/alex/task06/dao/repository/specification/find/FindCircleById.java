package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindCircleById extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindCircleById.class);

    /**
     * {@link by.alex.task06.domain.Figure} id.
     */
    private final long id;

    /**
     * Class constructor.
     *
     * @param idValue - id of figure
     */
    public FindCircleById(final long idValue) {
        this.id = idValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {
        LOGGER.info("Searching for circle specified by id");
        return id == circle.getId();
    }
}
