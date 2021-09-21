package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SortTriangleByName implements TriangleSortSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SortTriangleByName.class);

    @Override
    public int compare(final Triangle t1, final Triangle t2) {

        LOGGER.info("Comparing triangles by name");
        return t1.getName().compareTo(t2.getName());
    }
}
