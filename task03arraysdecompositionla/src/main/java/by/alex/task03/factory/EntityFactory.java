package by.alex.task03.factory;

import by.alex.task03.domain.BaseEntity;

public interface EntityFactory<T extends BaseEntity> {

    T create(Object... args);
}
