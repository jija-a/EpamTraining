package by.alex.task06.service.factory.impl;

import by.alex.task06.domain.Triangle;
import by.alex.task06.service.factory.FigureFactory;
import by.alex.task06.service.factory.WrongArgumentsException;

public class TriangleFactoryImpl implements FigureFactory<Triangle> {

    @Override
    public Triangle create(Object... args) throws WrongArgumentsException {
        return null;
    }
}
