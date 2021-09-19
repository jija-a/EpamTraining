package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;
import by.alex.task06.service.CircleService;
import by.alex.task06.service.ServiceFactory;

public final class FindCircleByPerimeter extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    private final double from;
    private final double to;
    private final CircleService service;

    public FindCircleByPerimeter(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
        this.service = ServiceFactory.FACTORY.getCircleService();
    }

    @Override
    public boolean isSpecified(final Circle circle) {

        double circlePerimeter = service.calcPerimeter(circle);
        return circlePerimeter >= from && circlePerimeter <= to;
    }
}
