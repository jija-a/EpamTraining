package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public class FindTriangleType extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private Triangle.TriangleType type;

    public FindTriangleType(Triangle.TriangleType type) {
        this.type = type;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        boolean toReturn = false;
        for (Triangle.TriangleType triangleType : triangle.getTypes()) {
            if (triangleType.equals(this.type)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }

    public Triangle.TriangleType getType() {
        return type;
    }

    public void setType(Triangle.TriangleType type) {
        this.type = type;
    }
}
