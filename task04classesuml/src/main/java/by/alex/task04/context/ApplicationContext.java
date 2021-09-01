package by.alex.task04.context;

import by.alex.task04.domain.AbstractBaseEntity;

import java.util.Collection;

public interface ApplicationContext {

    <T extends AbstractBaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass);

    void init() throws InitializingException;

}
