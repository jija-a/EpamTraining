package by.alex.task03.domain.factory.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.CustomArray;
import by.alex.task03.domain.factory.BaseEntityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomArrayFactoryImpl implements BaseEntityFactory<CustomArray> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFactoryImpl.class);
    public static final CustomArrayFactoryImpl ENTITY_FACTORY = new CustomArrayFactoryImpl();

    @Override
    public CustomArray create(Object... args) throws IllegalArgumentException {
        LOGGER.info("Creating custom array");

        int size = (int) args[0];

        if (size < 1) {
            LOGGER.warn("incompatible arguments for array creation (lesser than one)");
            throw new IllegalArgumentException("incompatible arguments for array creation");
        }

        CustomArray array = new CustomArray(size);
        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(CustomArray.class).add(array);
        return array;
    }

}
