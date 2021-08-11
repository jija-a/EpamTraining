package by.alex.task03.domain;

public abstract class AbstractBaseEntity implements BaseEntity {

    private Long id;

    public AbstractBaseEntity() {
    }

    @Override
    public Long getId() {
        return id;
    }

}
