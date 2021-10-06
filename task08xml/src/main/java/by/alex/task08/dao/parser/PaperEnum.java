package by.alex.task08.dao.parser;

public enum PaperEnum {
    PAPERS("papers"),
    BOOKLET("booklet"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    TITLE("title"),
    ID("id"),
    CHARS("chars"),
    GENRE("genre"),
    IS_MONTHLY("is-monthly"),
    IS_COLOR("is-color"),
    IS_GLANCE("is-glance"),
    SUBSCRIPT_INDEX("subscript-index");

    private final String value;

    PaperEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
