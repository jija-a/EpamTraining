package by.alex.task06.service.validator;

public class CircleValidator extends FigureValidator {

    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)(?:\\s(-?\\d+(\\.\\d+)?)){2}";

    @Override
    public boolean isFileLineMatchesRegex(final String line) {
        return line.matches(FILE_LINE_REGEX);
    }

    public boolean isCircleExists(final double radius) {
        return radius > 0;
    }

}
