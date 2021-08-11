package by.alex.task03.context;

public interface ApplicationMenu {

    ApplicationContext getApplicationContext();

    default Object printAvailableOptions() {
        return null;
    }

    default Object handleUserInput(Object o) {
        return null;
    }

}
