package com.epam.task02.context.impl;

import com.epam.task02.context.ApplicationContext;
import com.epam.task02.domain.ApplicationProperties;
import com.epam.task02.exception.InvalidStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContextImpl implements ApplicationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextImpl.class);
    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContextImpl();
    private final List<Double> numbers = new ArrayList<>();

    @Override
    public List<Double> retrieveNumbers() {
        LOGGER.trace("retrieving numbers from context");

        return numbers;
    }

    @Override
    public void init() throws InvalidStateException {
        LOGGER.info("initializing context");

        try {
            String fileName = ApplicationProperties.APPLICATION_PROPERTIES.getInputRootDir()
                    + ApplicationProperties.APPLICATION_PROPERTIES.getNumbersFileName();

            NumberReaderImpl.READER.read(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Numbers file not found");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Numbers file can't be read");
            System.exit(0);
        }

    }

}
