package com.zuehlke;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by urzy on 10.05.2017.
 */
public class MovieServiceAdapter {

    private final MovieServiceApiClient moviesApiClient;

    public MovieServiceAdapter(String url) {
        moviesApiClient = RestClientFactory.createClientWithoutFallback(url, MovieServiceApiClient.class);
    }

    public List<Movie> getAll() {
        List<MovieServiceResponse> responseMovies = moviesApiClient.getMovies();
        List<Movie> movies = new ArrayList<Movie>();
        for(MovieServiceResponse movieServiceResponse : responseMovies) {
            movies.add(mapResponse(movieServiceResponse));
        }
        return movies;
    }

    private Movie mapResponse(MovieServiceResponse movieServiceResponse) {
        return new Movie(movieServiceResponse.getId(), movieServiceResponse.getTitle(), movieServiceResponse.getPoster());
    }

    public Optional<MovieDetail> getMovieById(long id) {
        MovieServiceResponse movieServiceResponse = moviesApiClient.getMovieById(id);

        return Optional.of(new MovieDetail(
                movieServiceResponse.getId(),
                movieServiceResponse.getImdbId(),
                movieServiceResponse.getTitle(),
                movieServiceResponse.getPoster(),
                movieServiceResponse.getPlot(),
                movieServiceResponse.getYear(),
                movieServiceResponse.getGenre()));

    }

}
