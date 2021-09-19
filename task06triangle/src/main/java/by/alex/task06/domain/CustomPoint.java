package by.alex.task06.domain;

import java.util.Objects;

public final class CustomPoint extends Figure {

    private double x;
    private double y;

    public CustomPoint(final double xValue, final double yValue) {
        super();
        this.x = xValue;
        this.y = yValue;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(final double xValue) {
        this.x = xValue;
    }

    public void setY(final double yValue) {
        this.y = yValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomPoint point = (CustomPoint) o;
        return Double.compare(point.x, x) == 0
                && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }

}
