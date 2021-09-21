package by.alex.task06.service;

import by.alex.task06.domain.Circle;

public interface CircleService {

    /**
     * Method to calculate circle area.
     *
     * @param circle - circle instance
     * @return area of circle as double
     */
    double calcArea(Circle circle);

    /**
     * Method to calculate circle perimeter.
     *
     * @param circle - circle instance
     * @return perimeter of circle as double
     */
    double calcPerimeter(Circle circle);

    /**
     * Method to define if circle crosses only one axis.
     *
     * @param circle - circle instance
     * @return true - if crosses or false - if not
     */
    boolean isCircleCrossesOnlyOneAxis(Circle circle);
}
