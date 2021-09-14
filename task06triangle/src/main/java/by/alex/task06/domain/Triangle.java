package by.alex.task06.domain;

import java.util.List;
import java.util.Objects;

public class Triangle extends Figure {
    private enum TriangleType {
        ;
    }

    private final List<Point> points;
    private final String name;
    private final TriangleType type;

    public Triangle(List<Point> points, String name, TriangleType type) {
        this.points = points;
        this.name = name;
        this.type = type;
    }

    public List<Point> getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public TriangleType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return points.equals(triangle.points) && name.equals(triangle.name) && type == triangle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), points, name, type);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
