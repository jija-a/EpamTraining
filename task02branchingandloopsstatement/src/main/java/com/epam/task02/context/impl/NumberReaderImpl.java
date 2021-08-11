package com.epam.task02.context.impl;

import com.epam.task02.context.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NumberReaderImpl implements Reader {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberReaderImpl.class);
    public static final Reader READER = new NumberReaderImpl();

    private NumberReaderImpl() {
    }

    @Override
    public void read(String fileName) throws IOException {
        LOGGER.debug("reading numbers from file");

        List<Double> numbers = Files.lines(Paths.get(fileName))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveNumbers().addAll(numbers);
    }

}
