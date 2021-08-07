package com.epam.task02.context;

import java.io.IOException;
import java.util.List;

public interface Reader {

    List<Object> read(String fileName) throws IOException;
}
