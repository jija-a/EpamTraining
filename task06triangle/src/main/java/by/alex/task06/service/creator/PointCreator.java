package by.alex.task06.service.creator;

import by.alex.task06.domain.CustomPoint;

public class PointCreator {

    public static final PointCreator CREATOR = new PointCreator();

    private PointCreator() {
    }

    public CustomPoint create(final double x, final double y)
            throws WrongArgumentsException {

        //todo validate?
        return new CustomPoint(x, y);
    }
}
