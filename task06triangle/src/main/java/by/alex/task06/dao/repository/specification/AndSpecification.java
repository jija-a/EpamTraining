package by.alex.task06.dao.repository.specification;

import java.util.HashSet;
import java.util.Set;

public class AndSpecification<T> extends AbstractSpecification<T> {

    private Set<Specification<T>> set = new HashSet<Specification<T>>();

    public AndSpecification(Specification<T> a, Specification<T> b) {
        set.add(a);
        set.add(b);
    }

    @Override
    public boolean isSpecified(T t) {
        for (Specification<T> s : set) {
            if (!s.isSpecified(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public AbstractSpecification<T> and(Specification<T> s) {
        set.add(s);
        return this;
    }
}
