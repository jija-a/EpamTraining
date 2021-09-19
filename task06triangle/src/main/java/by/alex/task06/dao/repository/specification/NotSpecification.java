package by.alex.task06.dao.repository.specification;

public class NotSpecification<T> extends AbstractSpecification<T> {

    private final FindSpecification<T> spec;

    public NotSpecification(final FindSpecification<T> s) {
        this.spec = s;
    }

    @Override
    public boolean isSpecified(final T t) {
        return !spec.isSpecified(t);
    }
}
