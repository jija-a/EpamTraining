package by.alex.task06.dao.repository.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {

    @Override
    public abstract boolean isSpecified(T t);

    public AbstractSpecification<T> or(final Specification<T> s) {
        return new OrSpecification<>(this, s);
    }

    public AbstractSpecification<T> and(final Specification<T> s) {
        return new AndSpecification<>(this, s);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification<>(this);
    }
}
