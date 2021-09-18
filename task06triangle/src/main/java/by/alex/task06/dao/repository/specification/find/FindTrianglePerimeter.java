package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public class FindTrianglePerimeter extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private double from;
    private double to;

    public FindTrianglePerimeter(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        double trianglePerimeter = 0; //todo
        return trianglePerimeter >= from && trianglePerimeter <= to;
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
