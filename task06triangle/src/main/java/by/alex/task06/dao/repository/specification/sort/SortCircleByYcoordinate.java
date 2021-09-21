package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortCircleByYcoordinate implements CircleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortCircleByYcoordinate.class);

    @Override
    public int compare(final Circle c1, final Circle c2) {

        LOGGER.info("Comparing circles by y coordinate");
        return c1.getCenterPoint().getY()
                .compareTo(c2.getCenterPoint().getY());
    }
}
