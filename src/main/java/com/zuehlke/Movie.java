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

    public String toString() {
        return name + poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (!name.equals(movie.name)) return false;
        return poster.equals(movie.poster);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + poster.hashCode();
        return result;
    }
}
