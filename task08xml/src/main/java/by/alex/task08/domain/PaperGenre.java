package by.alex.task08.domain;

public enum PaperGenre {
    SPORT("sport"),
    LIFE("life"),
    EDUCATION("education"),
    NEWS("news"),
    TECH("tech");

    private final String value;

    PaperGenre(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static PaperGenre resolveGenreByString(String genreStr) {
        PaperGenre toReturn = PaperGenre.NEWS;

        for (PaperGenre genre : values()) {
            if (genre.getValue().equals(genreStr)) {
                toReturn = genre;
            }
        }
        return toReturn;
    }
}
