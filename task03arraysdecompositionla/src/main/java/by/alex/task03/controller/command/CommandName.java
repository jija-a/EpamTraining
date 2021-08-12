package by.alex.task03.controller.command;

public enum CommandName {

    ;

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
