package by.alex.task08.domain;

import java.util.Objects;

public abstract class Paper {

    private Long id;
    private String title;
    private Chars chars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return id.equals(paper.id) && title.equals(paper.title) && chars.equals(paper.chars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, chars);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id
                + ", title='" + title + '\''
                + ", chars=" + chars
                + '}';
    }

    public static class Chars {
        private Integer volume;
        private boolean monthly;
        private boolean color;
        private boolean glance;

        public Integer getVolume() {
            return volume;
        }

        public void setVolume(Integer volume) {
            this.volume = volume;
        }

        public boolean isMonthly() {
            return monthly;
        }

        public void setMonthly(boolean monthly) {
            this.monthly = monthly;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public boolean isGlance() {
            return glance;
        }

        public void setGlance(boolean glance) {
            this.glance = glance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Chars chars = (Chars) o;
            return monthly == chars.monthly
                    && color == chars.color
                    && glance == chars.glance
                    && volume.equals(chars.volume);
        }

        @Override
        public int hashCode() {
            return Objects.hash(volume, monthly, color, glance);
        }

        @Override
        public String toString() {
            return "Chars{" +
                    "volume=" + volume
                    + ", monthly=" + monthly
                    + ", color=" + color
                    + ", glance=" + glance
                    + '}';
        }
    }
}
