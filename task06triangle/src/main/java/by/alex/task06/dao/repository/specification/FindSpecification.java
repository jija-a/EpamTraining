package by.alex.task06.dao.repository.specification;

public interface FindSpecification<T> {

    /**
     * Method to know if {@link by.alex.task06.domain.Figure}
     * is specified.
     *
     * @param t {@link by.alex.task06.domain.Figure}
     * @return true if specified, else - false.
     */
    boolean isSpecified(T t);
}
