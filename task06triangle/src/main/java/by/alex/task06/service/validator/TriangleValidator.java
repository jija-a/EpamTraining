package by.alex.task06.service.validator;

public class TriangleValidator extends FigureValidator{

    private static final String FILE_LINE_REGEX =
            "(-?\\d+(\\.\\d+)?)(?:\\s(-?\\d+(\\.\\d+)?)){5}";

    @Override
    public boolean validateFileLineRegex(String line) {
        return line.matches(FILE_LINE_REGEX);
    }

}
