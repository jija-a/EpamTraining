package by.alex.task06.dao.repository.specification;

public interface Specification<T> {

    boolean isSpecified(T t);
}
