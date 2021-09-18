package by.alex.task06.service.validator;

import by.alex.task06.domain.CustomPoint;

import java.util.List;

public class TriangleValidator extends FigureValidator {

    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)(?:\\s(-?\\d+(\\.\\d+)?)){5}";

    @Override
    public boolean isFileLineMatchesRegex(String line) {
        return line.matches(FILE_LINE_REGEX);
    }

    public boolean isTriangleExists(List<CustomPoint> points) {

        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double x3 = points.get(2).getX();
        double y3 = points.get(2).getY();

        double s = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;

        return Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)) != 0;
    }

}
