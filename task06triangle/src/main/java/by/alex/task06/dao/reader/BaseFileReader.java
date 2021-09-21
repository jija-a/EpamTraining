package by.alex.task06.dao.reader;

import java.io.IOException;
import java.util.List;

public interface BaseFileReader {

    /**
     * Method to read file.
     *
     * @param filePath - path to file.
     * @return List of strings, file lines.
     */
    List<String> read(String filePath) throws IOException;
}
