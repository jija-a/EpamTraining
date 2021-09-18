package by.alex.task06.dao.reader;

import java.io.IOException;
import java.util.List;

public interface BaseFileReader {

    List<String> read(String filePath);
}
