package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;

import java.util.Comparator;

public class SortTriangleByXcoordinate implements TriangleSortSpecification, Comparator<Triangle> {

    @Override
    public int compare(Triangle t1, Triangle t2) {

        CustomPoint p1 = t1.getPoints().get(0);
        CustomPoint p2 = t2.getPoints().get(0);

        return p1.getX().compareTo(p2.getX());
    }
}
