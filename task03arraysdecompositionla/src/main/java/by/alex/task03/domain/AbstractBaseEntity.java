package by.alex.task03.domain;

public abstract class AbstractBaseEntity implements BaseEntity {

    private Long id;
    private static Long idCounter = 0L;

    public AbstractBaseEntity() {
        this.id = ++idCounter;
    }

    @Override
    public Long getId() {
        return id;
    }

}
