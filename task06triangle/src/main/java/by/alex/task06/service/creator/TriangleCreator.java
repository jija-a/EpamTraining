package by.alex.task06.service.creator;

import by.alex.task06.domain.CustomPoint;
import by.alex.task06.domain.Triangle;

import java.util.List;

public final class TriangleCreator {

    public static final TriangleCreator CREATOR = new TriangleCreator();

    public Triangle create(List<CustomPoint> points, String name) {

        //todo validate
        return new Triangle(points, name);
    }

}
