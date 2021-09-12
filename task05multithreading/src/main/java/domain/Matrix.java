package domain;

import java.util.Arrays;

public class Matrix extends AbstractBaseEntity {

    private final double[][] values;

    public Matrix(int rows, int columns) {
        values = new double[rows][columns];
    }

    public int getRows() {
        return values.length;
    }

    public int getColumns() {
        return values[0].length;
    }

    public double getElement(int row, int column) {
        return values[row][column];
    }

    public void setElement(int i, int j, double value) {
        values[i][j] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.deepEquals(values, matrix.values);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(values);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : id=" + getId() + " " + values.length + "x" + values[0].length + "\n");
        for (double[] row : values) {
            for (double value : row) {
                s.append(value + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
