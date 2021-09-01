package by.alex.task03.context.impl;

import by.alex.task03.context.ApplicationContext;
import by.alex.task03.context.InitializingException;
import by.alex.task03.context.config.ApplicationConfig;
import by.alex.task03.dao.EntityReaderFactory;
import by.alex.task03.domain.CustomArray;
import by.alex.task03.domain.BaseEntity;
import by.alex.task03.domain.Matrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextImpl.class);
    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContextImpl();

    private Collection<Matrix> matrixCollection = new ArrayList<>();
    private Collection<CustomArray> customArrayCollection = new ArrayList<>();

    private ApplicationContextImpl() {
    }

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        LOGGER.trace("Retrieving entity list from context");
        Collection<T> collection = new ArrayList<>();

        if (tClass.equals(Matrix.class)) {
            collection = (Collection<T>) matrixCollection;
        } else if (tClass.equals(CustomArray.class)) {
            collection = (Collection<T>) customArrayCollection;
        }

        return collection;
    }

    //todo service command
    @Override
    public void init() throws InitializingException {
        LOGGER.info("Initializing application context");

        String matrixFilePath = ApplicationConfig.getInputDir() + ApplicationConfig.getMatrixFileName();
        String arrayFilePath = ApplicationConfig.getInputDir() + ApplicationConfig.getArrayFileName();

        try {
            EntityReaderFactory.getInstance().getMatrixReader().read(matrixFilePath);
            EntityReaderFactory.getInstance().getArrayReader().read(arrayFilePath);
        } catch (IOException e) {
            LOGGER.error("Bad files", e);
            throw new InitializingException("bad files", e);
        }
    }

}
