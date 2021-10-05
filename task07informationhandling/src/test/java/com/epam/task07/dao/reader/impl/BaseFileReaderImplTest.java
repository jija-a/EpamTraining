package com.epam.task07.dao.reader.impl;

import com.epam.task07.dao.DaoException;
import com.epam.task07.dao.reader.BaseFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseFileReaderImplTest {

    @Test
    public void stringIsNotNull() throws DaoException {
        BaseFileReader reader = BaseFileReaderImpl.READER;
        String text = reader.read("input/test.txt");
        Assert.assertNotNull(text);
    }
}