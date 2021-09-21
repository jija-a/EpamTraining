package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortCircleById implements CircleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortCircleById.class);

    @Override
    public int compare(final Circle c1, final Circle c2) {

        LOGGER.info("Comparing circles by id");
        return c1.getId().compareTo(c2.getId());
    }
}
