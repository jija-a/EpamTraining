package by.alex.task06;

import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.impl.CircleRepositoryImpl;
import by.alex.task06.dao.repository.impl.TriangleRepositoryImpl;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.dao.repository.specification.find.FindTriangleById;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.creator.WrongArgumentsException;
import by.alex.task06.service.observer.listener.TriangleParameters;
import by.alex.task06.service.observer.listener.TriangleUpdateListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] ars) throws IOException, WrongArgumentsException, RepositoryException {

        TriangleRepositoryImpl.REPOSITORY.init();
        CircleRepositoryImpl.REPOSITORY.init();
        List<Triangle> triangles = TriangleRepositoryImpl.REPOSITORY.query(new FindTriangleById(1));
        Triangle triangle = triangles.get(0);
        System.out.println(triangle.toString());

        System.out.println(TriangleUpdateListener.LISTENER.getTriangle(1));


        /*List<CustomPoint> points = new ArrayList<>();
        CustomPoint point1 = new CustomPoint(1, 2);
        CustomPoint point2 = new CustomPoint(0, 1);
        points.add(point1);
        points.add(point2);

        List<Triangle> triangles = new ArrayList<>();
        Triangle triangle1 = new Triangle(points, "triangle1");
        Triangle triangle2 = new Triangle(points, "triangle2");
        triangles.add(triangle1);
        triangles.add(triangle2);

        System.out.println(getSpecifiedFigures(triangles, new FindTriangleByIdSpecification(3)
                .or(new FindTriangleByIdSpecification(4))));*/

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
