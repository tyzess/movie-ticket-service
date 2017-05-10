package com.zuehlke;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by urzy on 10.05.2017.
 */
public class MovieServiceResponse {

    private final long id;
    private final String imdbId;
    private final String title;
    private final String poster;
    private final String plot;
    private final String year;
    private final String genre;

    public MovieServiceResponse(@JsonProperty("id") long id,
                                @JsonProperty("imdbId") String imdbId,
                                @JsonProperty("title") String title,
                                @JsonProperty("poster") String poster,
                                @JsonProperty("plot") String plot,
                                @JsonProperty("year") String year,
                                @JsonProperty("genre") String genre) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.poster = poster;

        this.plot = plot;
        this.year = year;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getPlot() {
        return plot;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}
