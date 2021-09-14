package by.alex.task06.dao.reader.impl;

import by.alex.task06.dao.reader.BaseFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BaseFileReaderImpl implements BaseFileReader {

    @Override
    public List<String> read(String filePath) throws IOException {

        return Files.lines(Paths.get(filePath))
                .collect(Collectors.toList());
    }

}
