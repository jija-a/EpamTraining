package by.alex.task06.dao.repository.specification.sort;

import by.alex.task06.domain.Circle;

public final class SortCircleByYcoordinate implements CircleSortSpecification {

    @Override
    public int compare(final Circle c1, final Circle c2) {

        return c1.getCenterPoint().getY()
                .compareTo(c2.getCenterPoint().getY());
    }
}
