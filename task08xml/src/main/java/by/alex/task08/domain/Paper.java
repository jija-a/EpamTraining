package by.alex.task08.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Paper {

    /**
     * Entity id.
     */
    private Long id;

    /**
     * Entity title.
     */
    private String title;

    /**
     * Entity characteristics.
     *
     * @see Chars
     */
    private Chars chars;

    /**
     * Protected constructor (abstract class).
     *
     * @param idValue    - entity id
     * @param titleValue - entity title
     * @param charsValue - {@link Chars}
     */
    protected Paper(final Long idValue,
                    final String titleValue,
                    final Chars charsValue) {
        this.id = idValue;
        this.title = titleValue;
        this.chars = charsValue;
    }

    /**
     * Protected constructor.
     * <p>
     * Initializes chars
     * </p>
     */
    protected Paper() {
        this.chars = new Chars();
    }

    /**
     * Id getter.
     *
     * @return {@link Long} id
     */
    public Long getId() {
        return id;
    }

    /**
     * Id setter.
     *
     * @param idValue - entity id
     */
    public void setId(final Long idValue) {
        this.id = idValue;
    }

    /**
     * Title getter.
     *
     * @return {@link String} title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Title setter.
     *
     * @param t - {@link String} entity title
     */
    public void setTitle(final String t) {
        this.title = t;
    }

    /**
     * Chars getter.
     *
     * @return {@link Chars}
     */
    public Chars getChars() {
        return chars;
    }

    /**
     * Chars setter.
     *
     * @param ch - {@link Chars}
     */
    public void setChars(final Chars ch) {
        this.chars = ch;
    }

    /**
     * Method to define if entities equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paper paper = (Paper) o;
        return id.equals(paper.id)
                && title.equals(paper.title)
                && chars.equals(paper.chars);
    }

    /**
     * Method to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, chars);
    }

    /**
     * Method to get {@link String} presentation of entity.
     */
    @Override
    public String toString() {
        return "Paper{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", chars=" + chars
                + '}';
    }

    public static class Chars {
        /**
         * Date issue.
         */
        private LocalDate dateOfIssue;

        /**
         * {@link Paper} volume.
         */
        private Integer volume;

        /**
         * {@link Paper} genre.
         *
         * @see PaperGenre
         */
        private PaperGenre genre;

        /**
         * If {@link Paper} is monthly.
         */
        private boolean monthly;

        /**
         * If {@link Paper} has color.
         */
        private boolean color;

        /**
         * If {@link Paper} is glance.
         */
        private boolean glance;

        /**
         * Public default constructor.
         */
        public Chars() {
            this.genre = PaperGenre.NEWS;
        }

        /**
         * Public constructor.
         *
         * @param vol      - {@link Integer} volume
         * @param gen       - {@link PaperGenre} genre
         * @param mn     - {@link Boolean} if paper is monthly
         * @param clr       - {@link Boolean} if paper has color
         * @param gl      - {@link Boolean} if paper is glance
         * @param doi - {@link LocalDate} date of publication
         */
        public Chars(final Integer vol,
                     final PaperGenre gen,
                     final boolean mn,
                     final boolean clr,
                     final boolean gl,
                     final LocalDate doi) {

            this.volume = vol;
            this.genre = gen;
            this.monthly = mn;
            this.color = clr;
            this.glance = gl;
            this.dateOfIssue = doi;
        }

        /**
         * Public constructor.
         *
         * @param vol  - {@link Integer} volume
         * @param gen   - {@link PaperGenre} genre
         * @param mn - {@link Boolean} if paper is monthly
         * @param clr   - {@link Boolean} if paper has color
         * @param gl  - {@link Boolean} if paper is glance
         */
        public Chars(final Integer vol,
                     final PaperGenre gen,
                     final boolean mn,
                     final boolean clr,
                     final boolean gl) {

            this.volume = vol;
            this.genre = gen;
            this.monthly = mn;
            this.color = clr;
            this.glance = gl;
        }

        /**
         * Volume getter.
         *
         * @return {@link Integer}
         */
        public Integer getVolume() {
            return volume;
        }

        /**
         * Volume setter.
         *
         * @param vol - {@link Integer} volume
         */
        public void setVolume(final Integer vol) {
            this.volume = vol;
        }

        /**
         * Genre getter.
         *
         * @return {@link PaperGenre}
         */
        public PaperGenre getGenre() {
            return genre;
        }

        /**
         * Genre setter.
         *
         * @param gen - {@link PaperGenre}
         */
        public void setGenre(final PaperGenre gen) {
            this.genre = gen;
        }

        /**
         * If paper is monthly.
         *
         * @return {@link Boolean}
         */
        public boolean isMonthly() {
            return monthly;
        }

        /**
         * Monthly setter.
         *
         * @param mn - {@link Boolean}
         */
        public void setMonthly(final boolean mn) {
            this.monthly = mn;
        }

        /**
         * Color getter.
         *
         * @return {@link Boolean}
         */
        public boolean isColor() {
            return color;
        }

        /**
         * Color setter.
         *
         * @param clr - {@link Boolean}
         */
        public void setColor(final boolean clr) {
            this.color = clr;
        }

        /**
         * Glance getter.
         *
         * @return {@link Boolean}
         */
        public boolean isGlance() {
            return glance;
        }

        /**
         * Glance setter.
         *
         * @param gl - {@link Boolean}
         */
        public void setGlance(final boolean gl) {
            this.glance = gl;
        }

        /**
         * Date of publication getter.
         *
         * @return {@link LocalDate}
         */
        public LocalDate getDateOfIssue() {
            return dateOfIssue;
        }

        /**
         * Date of publication setter.
         *
         * @param doi - {@link LocalDate}
         */
        public void setDateOfIssue(final LocalDate doi) {
            this.dateOfIssue = doi;
        }

        /**
         * Method to define if entities are equal.
         */
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Chars chars = (Chars) o;
            return monthly == chars.monthly
                    && color == chars.color
                    && glance == chars.glance
                    && dateOfIssue.equals(chars.dateOfIssue)
                    && volume.equals(chars.volume)
                    && genre == chars.genre;
        }

        /**
         * Method to get entity hashcode.
         */
        @Override
        public int hashCode() {
            return Objects.hash(dateOfIssue,
                    volume,
                    genre,
                    monthly,
                    color,
                    glance);
        }

        /**
         * Method to get {@link String} representation of entity.
         */
        @Override
        public String toString() {
            return "Chars{"
                    + "dateOfIssue=" + dateOfIssue
                    + ", volume=" + volume
                    + ", genre=" + genre
                    + ", monthly=" + monthly
                    + ", color=" + color
                    + ", glance=" + glance
                    + '}';
        }
    }

}
