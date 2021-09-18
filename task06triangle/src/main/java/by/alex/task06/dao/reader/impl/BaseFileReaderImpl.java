package by.alex.task06.dao.reader.impl;

import by.alex.task06.dao.InitializingException;
import by.alex.task06.dao.reader.BaseFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseFileReaderImpl implements BaseFileReader {

    public static final BaseFileReader READER = new BaseFileReaderImpl();

    private BaseFileReaderImpl() {
    }

    @Override
    public List<String> read(String filePath) {

        try (Stream<String> stringStream = Files.lines(Paths.get(filePath))) {
            return stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new InitializingException(e);
        }

    }

}
