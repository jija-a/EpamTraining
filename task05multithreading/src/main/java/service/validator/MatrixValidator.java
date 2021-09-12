package service.validator;

import domain.Limit;
import domain.Matrix;

public class MatrixValidator {

    public static boolean validateLimit(Matrix matrix, Limit limit) {

        int matrixSize = matrix.getColumns();
        return matrixSize >= limit.getLowerLimit() && matrixSize <= limit.getHigherLimit();
    }

}
