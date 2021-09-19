package by.alex.task06.domain;

import java.util.Objects;

public final class Circle extends Figure {

    private CustomPoint centerPoint;
    private double radius;
    private String name;

    public Circle(final CustomPoint centerPointValue,
                  final double radiusValue,
                  final String nameValue) {

        this.centerPoint = centerPointValue;
        this.radius = radiusValue;
        this.name = nameValue;
    }

    public CustomPoint getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(final CustomPoint centerPointValue) {
        this.centerPoint = centerPointValue;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(final double radiusValue) {
        this.radius = radiusValue;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameValue) {
        this.name = nameValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0
                && Objects.equals(centerPoint, circle.centerPoint)
                && Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerPoint, radius, name);
    }

    @Override
    public String toString() {
        return "Circle{"
                + "centerPoint=" + centerPoint
                + ", radius=" + radius
                + ", name='" + name + '\''
                + '}';
    }
}
