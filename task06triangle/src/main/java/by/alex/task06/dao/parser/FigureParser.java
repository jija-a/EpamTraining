package by.alex.task06.dao.parser;

import by.alex.task06.domain.Figure;
import by.alex.task06.service.factory.WrongArgumentsException;

import java.util.List;

public interface FigureParser<T extends Figure> {

    List<T> parse(List<String> string) throws WrongArgumentsException;
}
