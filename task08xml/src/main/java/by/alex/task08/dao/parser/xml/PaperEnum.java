package by.alex.task08.dao.parser.xml;

public enum PaperEnum {
    PAPERS("papers"),
    TITLE("title");

    private final String value;

    PaperEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
