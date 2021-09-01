package by.alex.task03.domain;

import java.util.Objects;

public abstract class AbstractBaseEntity implements BaseEntity {

    private final long id;
    private static Long idCounter = 0L;

    public AbstractBaseEntity() {
        this.id = ++idCounter;
    }

    //todo
    @Override
    public Long getId() {
        return id;
    }

}
