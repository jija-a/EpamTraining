package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public final class FindTriangleType extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private final Triangle.TriangleType type;

    public FindTriangleType(final Triangle.TriangleType typeValue) {
        this.type = typeValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        boolean toReturn = false;
        for (Triangle.TriangleType triangleType : triangle.getTypes()) {
            if (triangleType.equals(this.type)) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }
}
