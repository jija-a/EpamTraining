package by.alex.task03.context.impl;

import by.alex.task03.context.ApplicationContext;
import by.alex.task03.domain.Array;
import by.alex.task03.domain.BaseEntity;
import by.alex.task03.domain.Matrix;
import by.alex.task03.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {

    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContextImpl();

    private Collection<Matrix> matrixCollection = new ArrayList<>();
    private Collection<Array> arrayCollection = new ArrayList<>();

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        Collection<T> collection = new ArrayList<>();

        if (tClass.equals(Matrix.class)) {
            collection = (Collection<T>) matrixCollection;
        } else if (tClass.equals(Array.class)) {
            collection = (Collection<T>) arrayCollection;
        }

        return collection;
    }

    @Override
    public void init() throws InvalidStateException {
        throw new InvalidStateException();
    }

}
