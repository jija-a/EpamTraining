package by.alex.task06.service.factory.impl;

import by.alex.task06.domain.Circle;
import by.alex.task06.service.factory.FigureFactory;
import by.alex.task06.service.factory.WrongArgumentsException;

public class CircleFactoryImpl implements FigureFactory<Circle> {

    @Override
    public Circle create(Object... args) throws WrongArgumentsException {
        return null;
    }
}
