package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;

public final class FindCircleByRadius extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    private final double from;
    private final double to;

    public FindCircleByRadius(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {

        double circleRadius = circle.getRadius();
        return circleRadius >= from && circleRadius <= to;
    }
}
