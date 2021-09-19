package by.alex.task06.dao.repository.specification;

import java.util.HashSet;
import java.util.Set;

public class OrSpecification<T> extends AbstractSpecification<T> {

    private final Set<FindSpecification<T>> set = new HashSet<>();

    public OrSpecification(final FindSpecification<T> a,
                           final FindSpecification<T> b) {
        set.add(a);
        set.add(b);
    }

    @Override
    public boolean isSpecified(final T t) {
        for (FindSpecification<T> s : set) {
            if (s.isSpecified(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractSpecification<T> or(final FindSpecification<T> s) {
        set.add(s);
        return this;
    }

}
