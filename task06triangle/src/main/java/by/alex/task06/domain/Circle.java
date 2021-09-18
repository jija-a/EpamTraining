package by.alex.task06.domain;

import java.util.Objects;

public class Circle extends Figure {

    private CustomPoint centerPoint;
    private double radius;
    private String name;

    public Circle(CustomPoint centerPoint, double radius) {
        super();
        this.radius = radius;
        this.centerPoint = centerPoint;
    }

    public CustomPoint getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(CustomPoint centerPoint) {
        this.centerPoint = centerPoint;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && centerPoint.equals(circle.centerPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerPoint, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerPoint=" + centerPoint +
                ", radius=" + radius +
                '}';
    }

}
