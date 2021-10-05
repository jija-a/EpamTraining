package com.epam.task07.dao.reader;

import com.epam.task07.dao.DaoException;

public interface BaseFileReader {

    /**
     * Method to read file.
     *
     * @param filePath - path to file.
     * @return List of strings, file lines.
     */
    String read(String filePath) throws DaoException;
}
