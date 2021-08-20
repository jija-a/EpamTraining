package by.alex.task03.domain.factory.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.factory.BaseEntityFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixFactoryImpl implements BaseEntityFactory<Matrix> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixFactoryImpl.class);
    public static final MatrixFactoryImpl ENTITY_FACTORY = new MatrixFactoryImpl();

    @Override
    public Matrix create(Object... args) throws IllegalArgumentException {
        LOGGER.info("Creating matrix");

        int rows = (int) args[0];
        int columns = (int) args[1];

        if ((rows < 1) || (columns < 1)) {
            LOGGER.warn("Incompatible arguments for creating matrix (columns or rows lesser than one)");
            throw new IllegalArgumentException("Incompatible arguments for creating matrix");
        }

        Matrix matrix = new Matrix(rows, columns);
        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class).add(matrix);
        return matrix;
    }

}
