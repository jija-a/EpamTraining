package by.alex.task03.service.validator;

import by.alex.task03.domain.Matrix;

public class MatrixValidator {


    public boolean isValidMatricesForMultiplying(Matrix firstMatrix, Matrix secondMatrix) {
        return firstMatrix.getColumns() == secondMatrix.getRows();
    }

    public boolean isValidMatricesForSumOrSubtract(Matrix firstMatrix, Matrix secondMatrix) {
        return firstMatrix.getColumns() == secondMatrix.getColumns()
                && firstMatrix.getRows() == secondMatrix.getRows();
    }

}
