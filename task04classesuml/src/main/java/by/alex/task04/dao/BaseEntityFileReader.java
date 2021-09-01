package by.alex.task04.dao;

import by.alex.task04.domain.AbstractBaseEntity;

import java.io.IOException;
import java.util.List;

public interface BaseEntityFileReader<T extends AbstractBaseEntity> {

    List<T> read(String filePath) throws IOException;
}
