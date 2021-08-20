package by.alex.task03.domain.factory;

public interface BaseEntityFactory<T> {

    T create (Object... args) throws IllegalArgumentException;

}
