package by.alex.task06.dao.reader;

import by.alex.task06.dao.InitializingError;

import java.util.List;

public interface BaseFileReader {

    /**
     * Method to read file.
     *
     * @param filePath - path to file.
     * @return List of strings, file lines.
     */
    List<String> read(String filePath) throws InitializingError;
}
