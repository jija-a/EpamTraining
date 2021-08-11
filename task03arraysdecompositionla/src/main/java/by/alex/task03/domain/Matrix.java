package by.alex.task03.domain;

import java.util.Arrays;

public class Matrix extends AbstractBaseEntity {

    private final int[][] values;

    public Matrix(int rows, int columns) {
        values = new int[rows][columns];
    }

    public int getRows() {
        return values.length;
    }

    public int getColumns() {
        return values[0].length;
    }

    public int getElement(int row, int column) throws MatrixException {
        if (checkRange(row, column)) {
            return values[row][column];
        }
        throw new MatrixException("incompatible range of matrix");
    }

    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            values[i][j] = value;
        } else {
            throw new MatrixException("incompatible range of matrix");
        }
    }

    private boolean checkRange(int rows, int columns) {
        if (rows >= 0 && rows < values.length && columns >= 0 && columns < values[0].length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(values, matrix.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + values.length + "x" + values[0].length + "\n");
        for (int[] row : values) {
            for (int value : row) {
                s.append(value + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
