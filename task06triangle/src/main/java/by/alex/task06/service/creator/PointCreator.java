package by.alex.task06.service.creator;

import by.alex.task06.domain.CustomPoint;

public final class PointCreator {

    public static final PointCreator CREATOR = new PointCreator();

    private PointCreator() {
    }

    public CustomPoint create(final double x, final double y) {

        CustomPoint point = new CustomPoint(x, y);
        return point;
    }
}
