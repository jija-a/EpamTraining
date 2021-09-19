package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public final class FindTriangleById extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private final long id;

    public FindTriangleById(final long idValue) {
        this.id = idValue;
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        return id == triangle.getId();
    }
}
