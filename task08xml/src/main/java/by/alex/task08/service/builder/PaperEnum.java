package by.alex.task08.service.builder;

public enum PaperEnum {
    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    PAPERS("papers"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    BOOKLET("booklet"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    NEWSPAPER("newspaper"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    MAGAZINE("magazine"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    ID("id"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    TITLE("title"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    CHARS("chars"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    DATE_OF_ISSUE("dateOfIssue"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    VOLUME("volume"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    GENRE("genre"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    IS_MONTHLY("is-monthly"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    IS_COLOR("is-color"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    IS_GLANCE("is-glance"),

    /**
     * {@link by.alex.task08.domain.Paper} xml tag.
     */
    SUBSCRIPT_INDEX("subscript-index");

    /**
     * {@link String} value of enum constant.
     */
    private final String value;

    PaperEnum(final String v) {
        this.value = v;
    }

    /**
     * Value getter.
     *
     * @return {@link String} value
     */
    public String getValue() {
        return value;
    }

    /**
     * Method to resolve enum constant by it value.
     *
     * @param filedStr - value of constant
     * @return {@link PaperEnum} constant
     */
    public static PaperEnum resolveFiledByString(final String filedStr) {
        PaperEnum toReturn = null;

        for (PaperEnum filed : values()) {
            if (filed.getValue().equals(filedStr.toLowerCase())) {
                toReturn = filed;
            }
        }
        return toReturn;
    }
}
