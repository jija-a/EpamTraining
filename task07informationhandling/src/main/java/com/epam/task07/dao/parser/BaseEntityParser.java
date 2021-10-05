package com.epam.task07.dao.parser;

public interface BaseEntityParser<T> {

    /**
     * Method to parse {@link String}.
     *
     * @param text - string to parse
     * @return <T>
     */
    T parse(String text);
}
