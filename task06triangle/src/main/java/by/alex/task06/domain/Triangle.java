package by.alex.task06.domain;

import java.util.List;
import java.util.Objects;

public class Triangle extends Figure {
    public enum TriangleType {
        RECTANGULAR,
        ISOSCELES,
        SHARP_ANGLED,
        OBTUSE,
        EQUILATERAL;
    }

    private List<CustomPoint> points;
    private String name;
    private List<TriangleType> types;

    public Triangle(final List<CustomPoint> pointsValue,
                    final String nameValue,
                    final List<TriangleType> typesValue) {

        this.points = pointsValue;
        this.name = nameValue;
        this.types = typesValue;
    }

    public Triangle(final List<CustomPoint> pointsValue,
                    final String nameValue) {

        this.points = pointsValue;
        this.name = nameValue;
    }

    public List<CustomPoint> getPoints() {
        return points;
    }

    public void setPoints(final List<CustomPoint> pointsValue) {
        this.points = pointsValue;
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameValue) {
        this.name = nameValue;
    }

    public List<TriangleType> getTypes() {
        return types;
    }

    public void setTypes(final List<TriangleType> typesValue) {
        this.types = typesValue;
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
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points)
                && Objects.equals(name, triangle.name)
                && Objects.equals(types, triangle.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), points, name, types);
    }

    @Override
    public String toString() {
        return "Triangle{"
                + "points=" + points
                + ", name='" + name + '\''
                + ", types=" + types
                + '}';
    }
}
