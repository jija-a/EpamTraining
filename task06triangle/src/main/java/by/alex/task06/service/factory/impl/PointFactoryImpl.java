package by.alex.task06.service.factory.impl;

import by.alex.task06.domain.Point;
import by.alex.task06.service.factory.FigureFactory;
import by.alex.task06.service.factory.WrongArgumentsException;

public class PointFactoryImpl implements FigureFactory<Point> {

    @Override
    public Point create(Object... args) throws WrongArgumentsException {
        return null;
    }
}
