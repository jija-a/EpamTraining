package by.alex.task06.service.creator;

import by.alex.task06.dao.repository.impl.CircleRepositoryImpl;
import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.service.validator.CircleValidator;

public final class CircleCreator {

    public static final CircleCreator CREATOR = new CircleCreator();

    private final CircleValidator validator;

    private CircleCreator() {
        this.validator = new CircleValidator();
    }

    public Circle create(final CustomPoint centerPoint, final double radius)
            throws WrongArgumentsException {

        if (validator.isCircleExists(radius)) {
            Circle circle = new Circle(centerPoint, radius);
            CircleRepositoryImpl.REPOSITORY.add(circle);
            return circle;
        }
        throw new WrongArgumentsException("Unable to create circle. "
                + "Radius 0 or lesser: " + radius);
    }

}
