package by.alex.task06.dao.parser;

import by.alex.task06.domain.Figure;

import java.util.List;

public interface FigureParser<T extends Figure> {

    /**
     * Method to parse figures from list of strings.
     *
     * @param string - list of file lines
     * @return List of figures
     */
    List<T> parse(List<String> string);
}
