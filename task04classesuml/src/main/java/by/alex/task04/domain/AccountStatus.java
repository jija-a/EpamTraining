package by.alex.task04.domain;

public enum AccountStatus {
    BLOCKED(1L),
    ACTIVE(2L);

    private final Long id;

    AccountStatus(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static AccountStatus resolveStatusById(Long id) throws UnknownEntityException {
        for (AccountStatus status : AccountStatus.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        throw new UnknownEntityException("Unknown status id: " + id);
    }

}
