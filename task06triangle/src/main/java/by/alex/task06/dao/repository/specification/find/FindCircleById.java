package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;

public final class FindCircleById extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    private final long id;

    public FindCircleById(final long idValue) {
        this.id = idValue;
    }

    @Override
    public boolean isSpecified(final Circle circle) {
        return id == circle.getId();
    }
}
