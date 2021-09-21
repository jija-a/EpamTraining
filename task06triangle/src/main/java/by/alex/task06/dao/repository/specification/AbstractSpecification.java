package by.alex.task06.dao.repository.specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSpecification<T> implements FindSpecification<T> {

    /**
     * Logger of this class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AbstractSpecification.class);

    /**
     * 'Or' specification to connect specifications.
     *
     * @param s - find specification that need to be connected
     * @return AbstractSpecification
     * with connected specification.
     */
    public AbstractSpecification<T> or(final FindSpecification<T> s) {
        LOGGER.info("Returning or specification instance");
        return new OrSpecification<>(this, s);
    }

    /**
     * 'And' specification to connect specifications.
     *
     * @param s - find specification that need to be connected
     * @return AbstractSpecification
     * @see AndSpecification
     */
    public AbstractSpecification<T> and(final FindSpecification<T> s) {
        LOGGER.info("Returning and specification instance");
        return new AndSpecification<>(this, s);
    }

    /**
     * 'Not' specification to denial previous specification.
     *
     * @return AbstractSpecification
     * @see NotSpecification
     */
    public AbstractSpecification<T> not() {
        LOGGER.info("Returning not specification instance");
        return new NotSpecification<>(this);
    }
}
