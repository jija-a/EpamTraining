package by.alex.task06.dao.repository.specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class OrSpecification<T> extends AbstractSpecification<T> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrSpecification.class);

    /**
     * Set of {@link FindSpecification}.
     */
    private final Set<FindSpecification<T>> set = new HashSet<>();

    /**
     * Class constructor.
     *
     * @param a - first specification
     * @param b - second specification
     */
    public OrSpecification(final FindSpecification<T> a,
                           final FindSpecification<T> b) {
        set.add(a);
        set.add(b);
    }

    /**
     * @see AbstractSpecification
     */
    @Override
    public boolean isSpecified(final T t) {
        LOGGER.info("Is specified in or specification");
        for (FindSpecification<T> s : set) {
            if (s.isSpecified(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @see AbstractSpecification
     */
    @Override
    public AbstractSpecification<T> or(final FindSpecification<T> s) {
        LOGGER.info("Set or specification");
        set.add(s);
        return this;
    }

}
