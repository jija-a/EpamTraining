package by.alex.task06.service;

import by.alex.task06.domain.Triangle;

import java.util.List;

public interface TriangleTypeService {

    List<Triangle.TriangleType> defineType(Triangle triangle);
}
