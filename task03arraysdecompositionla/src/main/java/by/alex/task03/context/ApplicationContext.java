package by.alex.task03.context;

import by.alex.task03.domain.BaseEntity;
import by.alex.task03.exception.InvalidStateException;

import java.util.Collection;

public interface ApplicationContext {

    <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass);

    void init() throws InvalidStateException;

}
