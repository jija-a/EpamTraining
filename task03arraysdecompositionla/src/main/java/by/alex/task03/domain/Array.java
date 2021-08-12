package by.alex.task03.domain;

import java.util.Arrays;

public class Array extends AbstractBaseEntity {

    private final double[] values;

    public Array(double[] values) {
        this.values = values;
    }

    public double[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array1 = (Array) o;
        return Arrays.equals(values, array1.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Array{"
                + Arrays.toString(values) +
                '}';
    }

}
