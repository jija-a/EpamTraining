package by.alex.task08.dao.parser;

public enum PaperEnum {
    PAPERS("papers"),
    BOOKLET("booklet"),
    NEWSPAPER("newspaper"),
    MAGAZINE("magazine"),
    ID("id"),
    TITLE("title"),
    CHARS("chars"),
    VOLUME("volume"),
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

    public static PaperEnum resolveFiledByString(String filedStr) {
        PaperEnum toReturn = null;

        for (PaperEnum filed : values()) {
            if (filed.getValue().equals(filedStr.toLowerCase())) {
                toReturn = filed;
            }
        }
        return toReturn;
    }
}
