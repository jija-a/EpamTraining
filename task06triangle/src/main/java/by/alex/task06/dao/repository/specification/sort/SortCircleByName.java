package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortCircleByName implements CircleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortCircleByName.class);

    @Override
    public int compare(final Circle c1, final Circle c2) {

        LOGGER.info("Comparing circles by name");
        return c1.getName().compareTo(c2.getName());
    }
}
