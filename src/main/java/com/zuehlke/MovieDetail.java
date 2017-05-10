package com.zuehlke;

/**
 * Created by urzy on 10.05.2017.
 */
public class MovieDetail {

    private final long id;
    private final String imdbId;
    private final String title;
    private final String poster;
    private final String plot;
    private final String year;
    private final String genre;

    public MovieDetail(long id,
                                String imdbId,
                                String title,
                                String poster,
                                String plot,
                                String year,
                                String genre) {
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

    public String getYear() {
        return year;
    }

    public String getPlot() {
        return plot;
    }

    public String getGenre() {
        return genre;
    }

    public String getImdbId() {
        return imdbId;
    }
}
