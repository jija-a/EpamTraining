package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public class FindTriangleById extends AbstractSpecification<Triangle> implements TriangleFindSpecification {

    private long id;

    public FindTriangleById(long id) {
        this.id = id;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        return id == triangle.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
