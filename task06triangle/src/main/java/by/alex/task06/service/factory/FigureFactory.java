package by.alex.task06.service.factory;

import by.alex.task06.domain.Figure;

public interface FigureFactory<T extends Figure> {

    T create(Object... args) throws WrongArgumentsException;
}
