package by.alex.task03.factory.impl;

import by.alex.task03.context.impl.ApplicationContextImpl;
import by.alex.task03.domain.Matrix;
import by.alex.task03.domain.MatrixException;
import by.alex.task03.factory.EntityFactory;

public class MatrixFactory implements EntityFactory<Matrix> {

    public static final MatrixFactory MATRIX_FACTORY = new MatrixFactory();

    private MatrixFactory() {
    }

    @Override
    public Matrix create(Object... args) throws MatrixException {
        if (!compatibleArguments(args)) {
            throw new MatrixException("Incompatible arguments for creating matrix");
        }

        Matrix matrix = new Matrix((int) args[0], (int) args[1]);
        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Matrix.class).add(matrix);

        return matrix;
    }

    private boolean compatibleArguments(Object... args) {
        if (args.length != 2) {
            return false;
        }

        int rows = (int) args[0];
        int columns = (int) args[1];

        return (rows >= 1) && (columns >= 1);
    }

}
