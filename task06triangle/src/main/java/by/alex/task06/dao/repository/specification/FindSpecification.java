package by.alex.task06.dao.repository.specification;

public interface FindSpecification<T> {

    boolean isSpecified(T t);
}
