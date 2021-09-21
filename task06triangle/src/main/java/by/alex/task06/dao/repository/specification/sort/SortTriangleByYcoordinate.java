package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortTriangleByYcoordinate
        implements TriangleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortTriangleByYcoordinate.class);

    @Override
    public int compare(final Triangle t1, final Triangle t2) {

        LOGGER.info("Comparing triangles by y coordinate");
        CustomPoint p1 = t1.getPoints().get(0);
        CustomPoint p2 = t2.getPoints().get(0);

        return p1.getY().compareTo(p2.getY());
    }
}
