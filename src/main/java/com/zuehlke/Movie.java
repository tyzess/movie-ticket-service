package com.zuehlke;

/**
 * Created by urzy on 10.05.2017.
 */
public class Movie {

    private final long id;
    private final String name;
    private final String poster;

    public Movie(long id, String name, String poster) {
        this.id = id;
        this.name = name;
        this.poster = poster;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPoster() {
        return poster;
    }

}
