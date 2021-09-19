package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;

public final class SortCircleByName implements CircleSortSpecification {

    @Override
    public int compare(final Circle c1, final Circle c2) {

        return c1.getName().compareTo(c2.getName());
    }
}
