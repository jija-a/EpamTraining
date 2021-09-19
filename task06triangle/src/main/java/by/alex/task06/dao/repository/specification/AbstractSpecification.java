package by.alex.task06.dao.repository.specification;

public abstract class AbstractSpecification<T> implements FindSpecification<T> {

    @Override
    public abstract boolean isSpecified(T t);

    public AbstractSpecification<T> or(final FindSpecification<T> s) {
        return new OrSpecification<>(this, s);
    }

    public AbstractSpecification<T> and(final FindSpecification<T> s) {
        return new AndSpecification<>(this, s);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification<>(this);
    }
}
