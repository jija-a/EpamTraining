package com.epam.task02.context.impl;

import com.epam.task02.context.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NumberReaderImpl implements Reader {

    @Override
    public List<Object> read(String fileName) throws IOException {
        return Files.lines(Paths.get("fileName"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
