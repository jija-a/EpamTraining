package by.alex.task03.domain;

import java.util.Arrays;

public class CustomArray extends AbstractBaseEntity {

    private final double[] values;

    public CustomArray(int size) {
        this.values = new double[size];
    }

    public double getValue(int i) {
        return values[i];
    }

    public int getSize() {
        return values.length;
    }

    public void setValue(int i, double value) {
        values[i] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray array = (CustomArray) o;
        return Arrays.equals(values, array.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Array{" +
                "id=" + getId() +
                "values=" + Arrays.toString(values) +
                "}\n";
    }
}
/*
public class AddItemService <T extends Number>  {
    private static <T extends Number> T calc (Item<T> arg1, Item<T> arg2){
        double a1 = arg1.getValue().doubleValue();
        double a2 = arg2.getValue().doubleValue();
        double res = a1 + a2;

        if (arg1.value instanceof Double) {
            return (T) new Double(res);
        } else if (arg1.value instanceof Integer) {
            return (T) new Integer((int)res);
...
*/
