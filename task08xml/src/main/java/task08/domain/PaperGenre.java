package task08.domain;

public enum PaperGenre {

    /**
     * {@link Paper} xml enum.
     */
    SPORT("sport"),

    /**
     * {@link Paper} xml enum.
     */
    LIFE("life"),

    /**
     * {@link Paper} xml enum.
     */
    EDUCATION("education"),

    /**
     * {@link Paper} xml enum.
     */
    NEWS("news"),

    /**
     * {@link Paper} xml enum.
     */
    TECH("tech");

    /**
     * {@link String} value of constant.
     */
    private final String value;

    PaperGenre(final String v) {
        this.value = v;
    }

    /**
     * Value getter.
     *
     * @return {@link String} value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Method to resolve enum constant by it string.
     *
     * @param genreStr - genre {@link String} value
     * @return {@link PaperGenre}
     */
    public static PaperGenre resolveGenreByString(final String genreStr) {
        PaperGenre toReturn = PaperGenre.NEWS;
        for (PaperGenre genre : values()) {
            if (genre.getValue().equals(genreStr)) {
                toReturn = genre;
            }
        }
        return toReturn;
    }
}
