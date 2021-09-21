package by.alex.task06.dao.reader.impl;

import by.alex.task06.dao.InitializingError;
import by.alex.task06.dao.reader.BaseFileReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseFileReaderImplTest {
    private BaseFileReader reader;

    @BeforeTest
    public void before() {
        reader = BaseFileReaderImpl.READER;
    }

    @Test(expectedExceptions = InitializingError.class)
    public void testExpectException() throws InitializingError {
        String WRONG_PATH = "./src/test/main/resoures/tri.txt";
        int actual = reader.read(WRONG_PATH).size();
    }

    @AfterTest
    public void after() {
        reader = null;
    }
}
