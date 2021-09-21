package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortTriangleById implements TriangleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortTriangleById.class);

    @Override
    public int compare(final Triangle t1, final Triangle t2) {

        LOGGER.info("Comparing triangles by id");
        return t1.getId().compareTo(t2.getId());
    }
}
