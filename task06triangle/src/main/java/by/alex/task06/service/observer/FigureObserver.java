package by.alex.task06.service.observer;

public interface FigureObserver {

    /**
     * Method to update figure {@link Characteristic}.
     *
     * @param event {@link FigureEvent}
     */
    void update(FigureEvent event);
}
