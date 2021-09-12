package service.factory.impl;

import domain.Matrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.factory.BaseEntityFactory;
import service.factory.WrongArgumentsException;

import javax.lang.model.UnknownEntityException;

public class MatrixFactory implements BaseEntityFactory<Matrix> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixFactory.class);

    @Override
    public Matrix create(Object... args) throws WrongArgumentsException {
        LOGGER.info("Creating matrix");
        Matrix matrix;
        try {
            if (args.length == 2) {
                matrix = this.createMatrixWithoutValues(args);
            } else if (args.length == 3) {
                matrix = this.createMatrixWithValues(args);
            } else {
                throw new WrongArgumentsException("Wrong parameters");
            }
        } catch (UnknownEntityException e) {
            LOGGER.error("Failed to create, wrong arguments");
            throw new WrongArgumentsException();
        }

        return matrix;
    }

    private Matrix createMatrixWithoutValues(Object... args) {
        int rows = Integer.parseInt((String) args[0]);
        int columns = Integer.parseInt((String) args[1]);
        return new Matrix(rows, columns);
    }

    private Matrix createMatrixWithValues(Object... args) {
        int rows = Integer.parseInt((String) args[0]);
        int columns = Integer.parseInt((String) args[1]);
        double[][] values = (double[][]) args[2];

        Matrix matrix = new Matrix(rows, columns);

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                matrix.setElement(i, j, values[i][j]);
            }
        }

        return matrix;
    }


}
