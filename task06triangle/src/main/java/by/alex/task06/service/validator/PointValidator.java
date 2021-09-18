package by.alex.task06.service.validator;

public class PointValidator extends FigureValidator{

    private static final String FILE_LINE_REGEX = "(-?\\d+(\\.\\d+)?)\\s(-?\\d+(\\.\\d+)?)";

    @Override
    public boolean isFileLineMatchesRegex(String line) {
        return line.matches(FILE_LINE_REGEX);
    }

}
