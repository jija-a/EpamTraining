package by.alex.task06.dao.repository.specification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotSpecification<T> extends AbstractSpecification<T> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(NotSpecification.class);

    /**
     * {@link FindSpecification}.
     */
    private final FindSpecification<T> spec;

    /**
     * Class constructor.
     *
     * @param s - {@link FindSpecification}
     */
    public NotSpecification(final FindSpecification<T> s) {
        this.spec = s;
    }

    /**
     * @see AbstractSpecification
     */
    @Override
    public boolean isSpecified(final T t) {
        LOGGER.info("Is specified in not specification");
        return !spec.isSpecified(t);
    }
}
