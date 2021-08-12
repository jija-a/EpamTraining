package by.alex.task03.context.impl;

import by.alex.task03.context.ApplicationContext;
import by.alex.task03.context.EntityReaderFactory;
import by.alex.task03.domain.ApplicationProperties;
import by.alex.task03.domain.Array;
import by.alex.task03.domain.BaseEntity;
import by.alex.task03.domain.Matrix;
import by.alex.task03.exception.InvalidStateException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {

    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContextImpl();

    private Collection<Matrix> matrixCollection = new ArrayList<>();
    private Collection<Array> arrayCollection = new ArrayList<>();

    private ApplicationContextImpl() {
    }

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
        String matrixFilePath = ApplicationProperties.APPLICATION_PROPERTIES.getInputDir()
                + ApplicationProperties.APPLICATION_PROPERTIES.getMatrixFileName();
        String arrayFilePath = ApplicationProperties.APPLICATION_PROPERTIES.getInputDir()
                + ApplicationProperties.APPLICATION_PROPERTIES.getArrayFileName();

        EntityReaderFactory readerFactory = EntityReaderFactory.getInstance();
        try {
            readerFactory.getMatrixReader().read(matrixFilePath);
            readerFactory.getArrayReader().read(arrayFilePath);
        } catch (IOException e) {
            throw new InvalidStateException("bad files", e);
        }
    }

}
