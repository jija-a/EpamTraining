package by.alex.task03.dao;

import by.alex.task03.dao.impl.ArrayFileReader;
import by.alex.task03.dao.impl.MatrixFileReader;

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
