package by.alex.task03.factory;

import by.alex.task03.domain.BaseEntity;
import by.alex.task03.domain.MatrixException;

public interface EntityFactory<T extends BaseEntity> {

    T create(Object... args) throws MatrixException;
}
