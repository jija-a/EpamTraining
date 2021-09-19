package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Triangle;

public final class SortTriangleByName implements TriangleSortSpecification {

    @Override
    public int compare(final Triangle t1, final Triangle t2) {

        return t1.getName().compareTo(t2.getName());
    }
}
