package by.alex.task06.domain;

import java.util.List;
import java.util.Objects;

public class Triangle extends Figure {
    private enum TriangleType {
        ;
    }

    private List<Point> points;
    private String name;
    private TriangleType type;

    public Triangle(List<Point> points, String name) {
        this.points = points;
        this.name = name;
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

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TriangleType type) {
        this.type = type;
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
