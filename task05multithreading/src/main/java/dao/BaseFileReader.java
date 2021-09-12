package dao;

import java.io.IOException;

public interface BaseFileReader {

    String read(String filePath) throws IOException;
}
