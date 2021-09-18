package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;

public class FindCircleByArea extends AbstractSpecification<Circle>
        implements CircleFindSpecification{

    @Override
    public boolean isSpecified(Circle circle) {
        return false;
    }
}
