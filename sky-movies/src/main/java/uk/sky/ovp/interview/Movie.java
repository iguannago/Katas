package uk.sky.ovp.interview;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movie {
    private String title;
    private Integer year;
    private List<String> genres;
    private List<String> cast;

    public Movie(@JsonProperty("title") String title,
                 @JsonProperty("year") Integer year,
                 @JsonProperty("genres") List<String> genres,
                 @JsonProperty("cast") List<String> cast) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "title='" + title + '\'' +
               ", year=" + year +
               ", genres=" + genres +
               ", cast=" + cast +
               '}';
    }
}
