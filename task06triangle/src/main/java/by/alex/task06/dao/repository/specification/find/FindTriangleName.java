package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public final class FindTriangleName extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private final String name;

    public FindTriangleName(final String nameValue) {
        this.name = nameValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        return name.equals(triangle.getName());
    }
}
