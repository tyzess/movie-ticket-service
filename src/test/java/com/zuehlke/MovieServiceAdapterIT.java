package com.zuehlke;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

/**
 * Created by urzy on 10.05.2017.
 */
// IntegrationTest
public class MovieServiceAdapterIT {

    // Hystrix will be explained later in the course
    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
    }

    @Test
    public void getAll() throws Exception {
        MovieServiceAdapter movieServiceAdapter = new MovieServiceAdapter("https://movie-service.herokuapp.com/");

        List<Movie> movies = movieServiceAdapter.getAll();

        assertThat(movies, hasSize(7));
        assertThat(movies, hasItem(new Movie(1, "Batman Begins", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg")));
    }

    @Test
    public void getMovieById() throws Exception {
        MovieServiceAdapter movieServiceAdapter = new MovieServiceAdapter("https://movie-service.herokuapp.com/");

        Optional<MovieDetail> movieDetail = movieServiceAdapter.getMovieById(1);

        assertThat(movieDetail.isPresent(), is(true));
    }
}