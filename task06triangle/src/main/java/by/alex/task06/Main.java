package by.alex.task06;

import by.alex.task06.dao.repository.impl.TriangleRepositoryImpl;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.dao.repository.specification.find.FindTriangleByIdSpecification;
import by.alex.task06.domain.Point;
import by.alex.task06.domain.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] ars) {
        List<Point> points = new ArrayList<>();
        Point point1 = new Point(1, 2);
        Point point2 = new Point(0, 1);
        points.add(point1);
        points.add(point2);

        List<Triangle> triangles = new ArrayList<>();
        Triangle triangle1 = new Triangle(points, "triangle1");
        Triangle triangle2 = new Triangle(points, "triangle2");
        triangles.add(triangle1);
        triangles.add(triangle2);

        System.out.println(getSpecifiedFigures(triangles, new FindTriangleByIdSpecification(3)
                .or(new FindTriangleByIdSpecification(4))));

    }

    static <T> List<T> getSpecifiedFigures(List<T> figures, Specification<T> specification) {
        List<T> specifiedFigures = new ArrayList<>();
        figures.forEach(figure -> {
            if (specification.isSpecified(figure)) {
                specifiedFigures.add(figure);
            }
        });
        return specifiedFigures;
    }

}
