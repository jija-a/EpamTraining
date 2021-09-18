package by.alex.task06.dao.repository.specification;

import java.util.HashSet;
import java.util.Set;

public class OrSpecification<T> extends AbstractSpecification<T> {

    private final Set<Specification<T>> set = new HashSet<>();

    public OrSpecification(Specification<T> a, Specification<T> b) {
        set.add(a);
        set.add(b);
    }

    @Override
    public boolean isSpecified(T t) {
        for( Specification<T> s : set ) {
            if( s.isSpecified(t) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractSpecification<T> or(Specification<T> s) {
        set.add(s);
        return this;
    }

}
