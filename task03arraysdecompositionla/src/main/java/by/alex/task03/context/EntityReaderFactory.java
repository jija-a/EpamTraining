package by.alex.task03.context;

import by.alex.task03.context.impl.ArrayFileReader;
import by.alex.task03.context.impl.MatrixFileReader;

public class EntityReaderFactory {

    public static final EntityReaderFactory instance = new EntityReaderFactory();

    private final BaseEntityFileReader arrayReader = new ArrayFileReader();
    private final BaseEntityFileReader matrixReader = new MatrixFileReader();

    private EntityReaderFactory() {
    }

    public static EntityReaderFactory getInstance() {
        return instance;
    }

    public BaseEntityFileReader getArrayReader() {
        return arrayReader;
    }

    public BaseEntityFileReader getMatrixReader() {
        return matrixReader;
    }

}
