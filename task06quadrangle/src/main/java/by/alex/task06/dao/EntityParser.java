package by.alex.task06.dao;

import by.alex.task06.service.factory.WrongArgumentsException;

public interface EntityParser<T> {

    T parse(String string) throws WrongArgumentsException;
}
