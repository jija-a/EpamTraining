package service.factory;

public interface BaseEntityFactory<T> {

    T create(Object... args) throws WrongArgumentsException;
}
