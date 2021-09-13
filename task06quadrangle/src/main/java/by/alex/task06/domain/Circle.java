package by.alex.task06.domain;

import java.util.Objects;

public class Circle extends Figure {

    private final Point centerPoint;
    private final double radius;

    public Circle(Point centerPoint, double radius) {
        this.radius = radius;
        this.centerPoint = centerPoint;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getRadius() {
        return radius;
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

    public class Point {
        private final double x;
        private final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

    }

}
