package by.alex.task04.domain;

public enum AccountStatus implements BaseEntity {

    BLOCKED(1L),
    ACTIVE(2L);

    private final Long id;

    AccountStatus(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "id=" + id +
                '}';
    }

}
