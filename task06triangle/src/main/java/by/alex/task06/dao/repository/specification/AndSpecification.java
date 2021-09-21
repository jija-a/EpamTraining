package by.alex.task06.dao.repository.specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class AndSpecification<T> extends AbstractSpecification<T> {

    /**
     * Logger of this class.
     *
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AndSpecification.class);

    /**
     * Set to store specifications.
     */
    private final Set<FindSpecification<T>> set = new HashSet<>();

    /**
     * Class constructor.
     *
     * @param a - first specification
     * @param b - second specification
     */
    public AndSpecification(final FindSpecification<T> a,
                            final FindSpecification<T> b) {
        set.add(a);
        set.add(b);
    }

    /**
     * @see FindSpecification
     */
    @Override
    public boolean isSpecified(final T t) {
        LOGGER.info("isSpecified in and specification");
        for (FindSpecification<T> s : set) {
            if (!s.isSpecified(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to connect specifications.
     *
     * @param s - specification to connect
     */
    @Override
    public AbstractSpecification<T> and(final FindSpecification<T> s) {
        LOGGER.info("Set and specification");
        set.add(s);
        return this;
    }
}
