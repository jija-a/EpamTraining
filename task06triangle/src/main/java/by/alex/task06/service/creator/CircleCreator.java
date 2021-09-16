package by.alex.task06.service.creator;

import by.alex.task06.domain.Circle;
import by.alex.task06.domain.CustomPoint;

public final class CircleCreator {

    public static final CircleCreator CREATOR = new CircleCreator();

    private CircleCreator() {
    }

    public Circle create(final CustomPoint centerPoint, final double radius)
            throws WrongArgumentsException {

        //todo validate
        return new Circle(centerPoint, radius);
    }

}
