package by.alex.task06.service.validator;

public interface FigureValidator {

    /**
     * Method to check if line of file matches
     * regular expression.
     *
     * @param line - file line
     * @return true - if matches, else - false
     */
    boolean isFileLineMatchesRegex(String line);
}
