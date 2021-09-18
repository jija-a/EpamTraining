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

    public Triangle(List<CustomPoint> points, String name, List<TriangleType> types) {
        super();
        this.points = points;
        this.name = name;
        this.types = types;
    }

    public Triangle(List<CustomPoint> points, String name) {
        super();
        this.points = points;
        this.name = name;
    }

    public List<CustomPoint> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public List<TriangleType> getTypes() {
        return types;
    }

    public void setPoints(List<CustomPoint> points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(List<TriangleType> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return points.equals(triangle.points) && name.equals(triangle.name) && types.equals(triangle.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), points, name, types);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                ", name='" + name + '\'' +
                ", type=" + types +
                '}';
    }
}
