package by.alex.task06.dao.reader.impl;

import by.alex.task06.dao.reader.BaseFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BaseFileReaderImpl implements BaseFileReader {

    public static final BaseFileReader READER = new BaseFileReaderImpl();

    private static final Logger LOGGER =
            LoggerFactory.getLogger(BaseFileReaderImpl.class);

    private BaseFileReaderImpl() {
    }

    @Override
    public List<String> read(final String filePath) throws IOException {

        LOGGER.info("Reading file with file path: {}", filePath);
        try (Stream<String> stringStream = Files.lines(Paths.get(filePath))) {
            return stringStream.collect(Collectors.toList());
        }
    }

}
