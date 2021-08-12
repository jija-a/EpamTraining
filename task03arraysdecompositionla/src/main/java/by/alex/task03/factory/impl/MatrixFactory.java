package by.alex.task03.factory.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Matrix;
import by.alex.task03.factory.EntityFactory;

public class MatrixFactory implements EntityFactory<Matrix> {

    public static final MatrixFactory MATRIX_FACTORY = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public Matrix create(Object... args) {

        Matrix matrix = new Matrix((int) args[0], (int) args[1]);
        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class).add(matrix);

        return matrix;
    }

}
