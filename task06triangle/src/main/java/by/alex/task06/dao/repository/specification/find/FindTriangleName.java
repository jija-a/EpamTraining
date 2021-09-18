package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;

public class FindTriangleName extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    private String name;

    public FindTriangleName(String name) {
        this.name = name;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        return name.equals(triangle.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
