package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Triangle;

import java.util.Comparator;

public class SortTriangleById implements TriangleSortSpecification, Comparator<Triangle> {

    @Override
    public int compare(Triangle t1, Triangle t2) {

        return t1.getId().compareTo(t2.getId());
    }
}
