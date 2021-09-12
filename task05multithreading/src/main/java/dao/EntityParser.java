package dao;

import service.factory.WrongArgumentsException;

import java.io.FileNotFoundException;
import java.util.List;

public interface EntityParser<T> {

    T parse(String string) throws WrongArgumentsException;
}
