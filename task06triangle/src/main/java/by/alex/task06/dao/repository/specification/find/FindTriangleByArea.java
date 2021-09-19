package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.TriangleService;

public final class FindTriangleByArea extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private final double from;
    private final double to;
    private final TriangleService service;

    public FindTriangleByArea(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
        this.service = ServiceFactory.FACTORY.getTriangleService();
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {

        double triangleArea = service.calcArea(triangle);
        return triangleArea >= from && triangleArea <= to;
    }
}
