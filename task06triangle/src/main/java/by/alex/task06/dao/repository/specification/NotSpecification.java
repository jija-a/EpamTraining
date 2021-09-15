package by.alex.task06.dao.repository.specification;

public class NotSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec;

    public NotSpecification(Specification<T> s) {
        this.spec=s;
    }

    @Override
    public boolean isSpecified(T t) {
        return !spec.isSpecified(t);
    }
}
