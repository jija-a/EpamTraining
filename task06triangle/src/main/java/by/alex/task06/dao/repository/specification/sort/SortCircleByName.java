package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;

import java.util.Comparator;

public class SortCircleByName implements CircleSortSpecification, Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {

        return c1.getName().compareTo(c2.getName());
    }
}
