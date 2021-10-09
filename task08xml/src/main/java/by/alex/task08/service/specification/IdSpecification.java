package by.alex.task08.service.specification;

import by.alex.task08.domain.Paper;

import java.util.Comparator;

public class IdSpecification implements Comparator<Paper> {

    /**
     * Method to compare two id of {@link Paper}.
     *
     * @param o1 - first {@link Paper} to compare
     * @param o2 - second {@link Paper} to compare
     */
    @Override
    public int compare(final Paper o1, final Paper o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
