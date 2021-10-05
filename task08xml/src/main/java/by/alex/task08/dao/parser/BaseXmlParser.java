package by.alex.task08.dao.parser;

import by.alex.task08.dao.DaoException;

public interface BaseXmlParser<T> {

    /**
     * Method to parse xml file.
     *
     * @param xmlFilePath - path to xml file
     * @return <T>
     */
    T parse(String xmlFilePath) throws DaoException;
}
