package com.zuehlke;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by urzy on 10.05.2017.
 */
// MovieServiceApiClient Interface
public interface MovieServiceApiClient {
    @RequestLine("GET /api/v1/movies")
    List<MovieServiceResponse> getMovies();

    @RequestLine("GET /api/v1/movies/{id}")
    MovieServiceResponse getMovieById(@Param("id") long id);
}