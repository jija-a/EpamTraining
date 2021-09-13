package service.validator;

import domain.Limit;

public class MatrixValidator {

    public static boolean validateLimit(int matrixSize, Limit limit) {

        return matrixSize >= limit.getLowerLimit() && matrixSize <= limit.getHigherLimit();
    }

}
