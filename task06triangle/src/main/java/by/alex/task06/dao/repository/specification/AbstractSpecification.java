package by.alex.task06.dao.repository.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {

    @Override
    public abstract boolean isSpecified(T t);

    public AbstractSpecification<T> or(Specification<T> s) {
        return new OrSpecification<T>(this,s);
    }

    public AbstractSpecification<T> and(Specification<T> s) {
        return new AndSpecification<T>(this,s);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification<T>(this);
    }
}
