package com.epam.task07.dao.reader.impl;

import com.epam.task07.dao.DaoException;
import com.epam.task07.dao.reader.BaseFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class BaseFileReaderImpl implements BaseFileReader {

    /**
     * Logger of this class.
     *
     * @see Logger
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
    public String read(final String filePath) throws DaoException {

        LOGGER.info("Reading file with file path: {}", filePath);
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filePath);
        if (url == null) {
            throw new DaoException("url is null");
        }

        File file = new File(url.getFile());
        String absolutePath = file.getAbsolutePath();
        try {
            return Files.readString(Paths.get(absolutePath));
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
