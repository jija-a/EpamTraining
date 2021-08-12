package by.alex.task03.factory.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Array;
import by.alex.task03.factory.EntityFactory;

public class ArrayFactory implements EntityFactory<Array> {

    public static final ArrayFactory ARRAY_FACTORY = new ArrayFactory();

    private ArrayFactory() {
    }

    @Override
    public Array create(Object... args) {
        Array array = new Array((double[]) args[0]);
        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Array.class).add(array);
        return array;
    }

}
