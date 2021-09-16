package by.alex.task06.dao.parser;

import by.alex.task06.domain.Figure;

import java.util.List;

public interface FigureParser<T extends Figure> {

    List<T> parse(List<String> string);
}
