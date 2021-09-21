package by.alex.task06.service.observer;

import by.alex.task06.domain.Figure;

import java.util.EventObject;

public class FigureEvent extends EventObject {

    /**
     * Class constructor.
     *
     * @param source {@link Figure}
     * @see EventObject
     */
    public FigureEvent(final Figure source) {
        super(source);
    }

    /**
     * @return {@link Figure}
     * @see EventObject
     */
    @Override
    public Figure getSource() {
        return (Figure) super.getSource();
    }
}
