package by.alex.task06.service.creator;

import by.alex.task06.dao.repository.impl.TriangleRepositoryImpl;
import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.validator.TriangleValidator;

import java.util.List;

public final class TriangleCreator {

    public static final TriangleCreator CREATOR = new TriangleCreator();

    private final TriangleValidator validator;

    private TriangleCreator() {
        this.validator = new TriangleValidator();
    }

    public Triangle create(final List<CustomPoint> points, final String name)
            throws WrongArgumentsException {

        if (validator.isTriangleExists(points)) {
            Triangle triangle = new Triangle(points, name);
            List<Triangle.TriangleType> types = ServiceFactory.FACTORY
                    .getTriangleTypesService().defineType(triangle);
            triangle.setTypes(types);
            TriangleRepositoryImpl.REPOSITORY.add(triangle);
            return triangle;
        }
        throw new WrongArgumentsException("Unable to create triangle. "
                + "It does not exist");
    }

}
