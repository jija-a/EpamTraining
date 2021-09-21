package by.alex.task06.service.observer;

public interface Observable {

    /**
     * Method to attach {@link FigureObserver} to
     * observable {@link by.alex.task06.domain.Figure}.
     *
     * @param observer  - {@link FigureObserver}
     * @param observers - optional list of {@link FigureObserver}
     */
    void attach(FigureObserver observer,
                FigureObserver... observers);

    /**
     * Method to detach {@link FigureObserver} from
     * observable {@link by.alex.task06.domain.Figure}.
     *
     * @param observer - {@link FigureObserver}
     * @param list     - optional list of {@link FigureObserver}
     */
    void detach(FigureObserver observer,
                FigureObserver... list);

    /**
     * Method which notifies {@link by.alex.task06.domain.Figure}
     * that {@link by.alex.task06.domain.Figure} parameters are changed.
     */
    void notifyObservers();
}
