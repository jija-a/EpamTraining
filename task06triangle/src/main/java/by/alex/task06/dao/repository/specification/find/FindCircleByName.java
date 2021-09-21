package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindCircleByName extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindCircleByName.class);

    /**
     * {@link by.alex.task06.domain.Figure} name.
     */
    private final String name;

    /**
     * Class constructor.
     *
     * @param nameValue - {@link by.alex.task06.domain.Figure} name
     */
    public FindCircleByName(final String nameValue) {
        this.name = nameValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {
        LOGGER.info("Searching for circle specified by name");
        return name.equals(circle.getName());
    }
}
