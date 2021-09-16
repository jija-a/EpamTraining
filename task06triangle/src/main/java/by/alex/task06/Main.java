package by.alex.task06;

import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.dao.reader.BaseFileReader;
import by.alex.task06.dao.reader.impl.BaseFileReaderImpl;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.domain.Circle;
import by.alex.task06.service.creator.WrongArgumentsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] ars) throws IOException, WrongArgumentsException {

        BaseFileReader reader = BaseFileReaderImpl.READER;
        List<String> strings = reader.read("task06triangle/src/main/resources/input/circle.txt");
        List<Circle> circles = FigureParserFactory.PARSER_FACTORY.getCirclesParser().parse(strings);
        System.out.println(circles.toString());

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
