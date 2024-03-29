package by.alex.task06.dao.reader.impl;

import by.alex.task06.dao.InitializingError;
import by.alex.task06.dao.reader.BaseFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BaseFileReaderImpl implements BaseFileReader {

    /**
     * Logger of this class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(BaseFileReaderImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final BaseFileReader READER = new BaseFileReaderImpl();

    private BaseFileReaderImpl() {
    }

    @Override
    public List<String> read(final String filePath) {
        LOGGER.info("Reading file with file path: {}", filePath);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        String absolutePath = file.getAbsolutePath();

        try (Stream<String> stringStream =
                     Files.lines(Paths.get(absolutePath))) {
            return stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new InitializingError(e);
        }
    }

}
