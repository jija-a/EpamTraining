package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;

public final class SortCircleById implements CircleSortSpecification {

    @Override
    public int compare(final Circle c1, final Circle c2) {

        return c1.getId().compareTo(c2.getId());
    }
}
