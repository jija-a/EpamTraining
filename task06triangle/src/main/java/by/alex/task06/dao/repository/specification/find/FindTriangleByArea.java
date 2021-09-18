package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public class FindTriangleByArea extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private double from;
    private double to;

    public FindTriangleByArea(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double triangleArea = 0; //todo
        return triangleArea >= from && triangleArea <= to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }
}
