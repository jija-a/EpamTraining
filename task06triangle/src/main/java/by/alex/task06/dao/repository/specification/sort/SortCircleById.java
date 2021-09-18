package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;

import java.util.Comparator;

public class SortCircleById implements CircleSortSpecification, Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {

        return c1.getId().compareTo(c2.getId());
    }
}
