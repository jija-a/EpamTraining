package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;

public final class FindCircleByName extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    private final String name;

    public FindCircleByName(final String nameValue) {
        this.name = nameValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {
        return name.equals(circle.getName());
    }
}
