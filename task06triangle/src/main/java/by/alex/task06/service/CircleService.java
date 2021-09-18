package by.alex.task06.service;

import by.alex.task06.domain.Circle;

public interface CircleService {

    double calcArea(Circle circle);

    double calcPerimeter(Circle circle);

    boolean isCircleCrossesOnlyOneAxis(Circle circle, double distance);
}
