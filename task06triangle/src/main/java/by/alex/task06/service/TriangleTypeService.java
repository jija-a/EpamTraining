package by.alex.task06.service;

import by.alex.task06.domain.Triangle;

import java.util.List;

public interface TriangleTypeService {

    /**
     * Method to define triangle type.
     *
     * @param triangle - {@link Triangle} object
     * @return {@link List} of
     * {@link by.alex.task06.domain.Triangle.TriangleType}
     */
    List<Triangle.TriangleType> defineType(Triangle triangle);
}
