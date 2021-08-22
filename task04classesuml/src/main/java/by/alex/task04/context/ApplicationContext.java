package by.alex.task04.context;

import by.alex.task04.domain.BaseEntity;

import java.util.Collection;

public interface ApplicationContext {


    <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass);

    void init() throws InitializingException;

}
