package task08.service.builder;

import task08.domain.Paper;

public enum PaperEnum {
    /**
     * {@link Paper} xml tag.
     */
    PAPERS("papers"),

    /**
     * {@link Paper} xml tag.
     */
    BOOKLET("booklet"),

    /**
     * {@link Paper} xml tag.
     */
    NEWSPAPER("newspaper"),

    /**
     * {@link Paper} xml tag.
     */
    MAGAZINE("magazine"),

    /**
     * {@link Paper} xml tag.
     */
    ID("id"),

    /**
     * {@link Paper} xml tag.
     */
    TITLE("title"),

    /**
     * {@link Paper} xml tag.
     */
    CHARS("chars"),

    /**
     * {@link Paper} xml tag.
     */
    DATE_OF_ISSUE("dateOfIssue"),

    /**
     * {@link Paper} xml tag.
     */
    VOLUME("volume"),

    /**
     * {@link Paper} xml tag.
     */
    GENRE("genre"),

    /**
     * {@link Paper} xml tag.
     */
    IS_MONTHLY("is-monthly"),

    /**
     * {@link Paper} xml tag.
     */
    IS_COLOR("is-color"),

    /**
     * {@link Paper} xml tag.
     */
    IS_GLANCE("is-glance"),

    /**
     * {@link Paper} xml tag.
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
