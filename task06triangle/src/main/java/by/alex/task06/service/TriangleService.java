package by.alex.task06.service;

import by.alex.task06.domain.Triangle;

public interface TriangleService {

    /**
     * Method to calculate area of triangle.
     *
     * @param triangle - {@link Triangle} instance
     * @return {@link Double} area value
     */
    double calcArea(Triangle triangle);

    /**
     * Method to calculate perimeter of triangle.
     *
     * @param triangle - {@link Triangle} instance
     * @return {@link Double} perimeter value
     */
    double calcPerimeter(Triangle triangle);
}
